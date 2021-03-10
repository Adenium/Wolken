package org.wolkenproject.core.script.internal;

import org.wolkenproject.core.script.MochaFunction;

public class MochaObject {
    private MochaObject functions[];

    public MochaObject add(MochaObject other) { return this; }
    public MochaObject sub(MochaObject other) { return this; }
    public MochaObject mul(MochaObject other) { return this; }
    public MochaObject div(MochaObject other, boolean sign) { return this; }
    public MochaObject mod(MochaObject other, boolean sign) { return this; }
    public MochaObject shiftRight(MochaObject other, boolean sign) { return this; }
    public MochaObject shiftLeft(MochaObject other, boolean sign) { return this; }
    public MochaObject arithmeticShift(MochaObject other, boolean sign) { return this; }
    // equals (x==y)
    public MochaObject equal(MochaObject other) { return this; }
    // and (x&y)
    public MochaObject and(MochaObject other) { return this; }
    // or (x|y)
    public MochaObject or(MochaObject other) { return this; }
    // xor (x^y)
    public MochaObject xor(MochaObject other) { return this; }
    // not (!x)
    public MochaObject not() { return this; }
    // negate (~x)
    public MochaObject negate() { return this; }
    // get the length of an array
    public MochaObject length() { return this; }
    // get the shape of an array
    public MochaObject shape() { return this; }
    // reshape an array
    public MochaObject reshape(MochaObject shape) { return this; }
    // add an element to the back
    public MochaObject append(MochaObject object) { return this; }
    // add an element to the front
    public MochaObject prepend(MochaObject object) { return this; }
    // pop the last element
    public MochaObject pop() { return this; }
    // poll the first element
    public MochaObject poll() { return this; }
}
