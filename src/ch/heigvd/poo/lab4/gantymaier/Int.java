/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo4
 * Fichier : Int.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 19.10.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier
 * Compilateur : OpenJDK 11
 * ---------------------------
 */

package ch.heigvd.poo.lab4.gantymaier;

/**
 * documentation de Int
 */
public class Int {
    private int value;

    /**
     * @param first
     * @param second
     * @author Elliot Ganty et Damien Maier
     */
    public static void swapValues(Int first, Int second) {
        int temp = first.value;
        first.value = second.value;
        second.value = temp;
    }

    public static void swapArrayElements(Int[] array, int firstIndex, int secondIndex) {
        Int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
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
