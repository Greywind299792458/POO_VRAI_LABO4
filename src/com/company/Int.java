/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo4
 * Fichier : Int.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 18.10.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier
 * Compilateur : OpenJDK 11
 * ---------------------------
 */

package com.company;

public class Int {
    private int value;

    static public void swapValues(Int first, Int second) {
        int temp = first.value;
        first.value = second.value;
        second.value = temp;
    }

    public Int(int value) {
        this.value = value;
    }

    public void swapValues(Int other) {
        int temp = value;
        value = other.value;
        other.value = temp;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
