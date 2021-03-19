package org.wolkenproject.core;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BlockStateChange {
    private Queue<byte[]>   transactionIds;
    private Queue<byte[]>   transactionEventIds;
    private List<Event>     transactionEvents;

    public BlockStateChange() {
        this.transactionIds         = new LinkedList<>();
        this.transactionEventIds    = new LinkedList<>();
        this.transactionEvents      = new LinkedList<>();
    }

    public BlockStateChangeResult getResult() {
        return new BlockStateChangeResult(transactionIds, transactionEventIds, transactionEvents);
    }
}
