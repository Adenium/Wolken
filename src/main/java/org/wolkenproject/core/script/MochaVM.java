package org.wolkenproject.core.script;

import java.util.Set;

public class MochaVM extends VirtualMachine {
    private Set<Opcode> opcodeSet;

    @Override
    public ExecutionResult execute(Script script) {
        return null;
    }

    @Override
    public void addOp(String name, boolean hasArgs, int lenArgs, int maxLenArgs, String desc, Opcode opcode) {
        opcode.setIdentifier(opcodeSet.size());
        opcode.setHasArguments(hasArgs);
        opcode.setArgumentLength(lenArgs);
        opcode.setMaxArgumentLength(maxLenArgs);
        opcode.setDescription(desc);
        opcodeSet.add(opcode);
    }
}
