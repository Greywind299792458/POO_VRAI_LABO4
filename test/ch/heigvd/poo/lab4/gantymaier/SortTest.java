/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo4
 * Fichier : SortTest.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 19.10.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier
 * Compilateur : OpenJDK 11
 * ---------------------------
 */

package ch.heigvd.poo.lab4.gantymaier;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    void primitiveIntSort() {
        int[] arrayTestedSort = {1337, 10, -42, 10};
        int[] arrayCorrectSort = arrayTestedSort.clone();
        Sort.sort(arrayTestedSort);
        Arrays.sort(arrayCorrectSort);
        assertArrayEquals(arrayCorrectSort, arrayTestedSort);
    }

    @Test
    void objectIntSort() {
        Int[] arrayTestedSort = {new Int(1337), new Int(10), new Int(-42), new Int(10)};
        Int[] arrayCorrectSort = {new Int(-42), new Int(10), new Int(10), new Int(1337)};
        Sort.sort(arrayTestedSort);
        assertEquals(Arrays.toString(arrayCorrectSort), Arrays.toString(arrayTestedSort));
    }
}