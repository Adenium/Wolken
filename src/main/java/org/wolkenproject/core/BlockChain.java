package org.wolkenproject.core;

import org.wolkenproject.exceptions.WolkenException;
import org.wolkenproject.utils.Utils;

import java.math.BigInteger;
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

public class BlockChain implements Runnable {
    private BlockIndex          tip;
    private byte[]              chainWork;
    // contains random blocks sent from peers.
    private Queue<BlockIndex>   blockPool;
    private Queue<BlockIndex>   orphanedBlocks;

    private ReentrantLock   lock;

    public final void consensus()
    {
    }

    @Override
    public void run() {
        lock.lock();
        try {
            while (!blockPool.isEmpty()) {
                BlockIndex block = blockPool.poll();
                if (block.getChainWork().compareTo(tip.getChainWork()) > 0) {
                    // switch to this chain if it's valid
                    if (block.validate()) {
                        if (block.getHeight() == tip.getHeight()) {
                            // if both blocks share the same height, then orphan the current tip.
                            replaceTip(block);
                        } else if (block.getHeight() == (tip.getHeight() + 1)) {
                            // if block is next in line then set as next block.
                            setNext(block);
                        } else if (block.getHeight() > tip.getHeight()) {
                            // if block next but with some blocks missing then we fill the gap.
                            setNextGapped(block);
                        } else if (block.getHeight() < tip.getHeight()) {
                            // if block is earlier then we must roll back the chain.
                            rollback(block);
                        }
                    }
                }
            }
        } finally {
            lock.unlock();
        }
    }

    private void replaceTip(BlockIndex block) {
        addOrphan(tip);
        byte previousHash[] = tip.getBlock().getParentHash();
        if (Utils.equals(block.getBlock().getParentHash(), previousHash)) {
            setTip(block);
            return;
        }
    }

    private void setTip(BlockIndex block) {
        tip = block;
    }

    private void addOrphan(BlockIndex block) {
        orphanedBlocks.add(block);
    }

    public BlockIndex makeGenesisBlock() throws WolkenException {
        Block genesis = new Block(new byte[Block.UniqueIdentifierLength], 0);
        genesis.addTransaction(TransactionI.newCoinbase(0, "", Context.getInstance().getNetworkParameters().getMaxReward(), Context.getInstance().getPayList()));
        return new BlockIndex(genesis, BigInteger.ZERO, 0);
    }

    public BlockIndex makeBlock() throws WolkenException {
        lock.lock();
        try {
            return tip.generateNextBlock();
        }
        finally {
            lock.unlock();
        }
    }
}
