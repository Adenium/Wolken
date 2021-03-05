package org.wolkenproject.core;

import org.wolkenproject.utils.PriorityHashQueue;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class TransactionPool {
    private Queue<TransactionI>         transactions;
    private ReentrantLock               mutex;
    private static final int            MaximumBlockQueueSize = 1_250_000_000;

    public TransactionPool() {
        transactions    = new PriorityHashQueue<>();
    }

    public boolean contains(byte[] txid) {
        return transactions.containsKey(txid);
    }

    public Set<byte[]> getNonDuplicateTransactions(Set<byte[]> list) {
        Set<byte[]> result = new HashSet<>();

        for (byte[] txid : list) {
            if (!contains(txid)) {
                result.add(txid);
            }
        }

        return result;
    }

    public TransactionI getTransaction(byte[] txid) {
        return transactions.get(txid);
    }
}