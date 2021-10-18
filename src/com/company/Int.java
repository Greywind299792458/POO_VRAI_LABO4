package com.company;

public class Int {

    private int value;

    Int(int i) {
        value = i;
    }

    int get() {
        return value;
    }

    String print() {
        return value + " (adr = " + this + ")";
    }

    void set(int newValue) {
        value = newValue;
    }

    void swap(Int other) {
        swapValues(this, other);
    }

    static void swapValues(Int a, Int b) {
        int c = a.get();
        a.set(b.get());
        b.set(c);
    }

    static Int[] swapVariables(Int[] tab, int index1, int index2) {
        Int[] copy;
        copy = tab;
        Int tmp = copy[index1];
        copy[index1] = copy[index2];
        copy[index2] = tmp;
        return copy;
    }

    static void printTabInt(Int[] tab) {
        System.out.println("[ ");
        for(Int el : tab) {
            System.out.println(el.print());
        }
        System.out.println(" ] \n");
    }
}
