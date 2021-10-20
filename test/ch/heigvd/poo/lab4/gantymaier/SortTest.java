/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo4
 * Fichier : SortTest.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 19.10.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier.
 * Compilateur : OpenJDK 11
 * ---------------------------
 */

package ch.heigvd.poo.lab4.gantymaier;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Teste en particulier les 2 méthodes de tris accessibles dans la classe Sort
 * avec un tableau d'entiers ou d'objets Int
 */
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
    void primitiveIntSortOneValue() {
        int[] arrayTestedSort = {1337};
        int[] arrayCorrectSort = arrayTestedSort.clone();
        Sort.sort(arrayTestedSort);
        Arrays.sort(arrayCorrectSort);
        assertArrayEquals(arrayCorrectSort, arrayTestedSort);
    }

    @Test
    void primitiveIntSortEmpty() {
        int[] arrayTestedSort = {};
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

    @Test
    void objectIntSortOneValue() {
        Int[] arrayTestedSort = {new Int(1)};
        Int[] arrayCorrectSort = {new Int(1)};
        Sort.sort(arrayTestedSort);
        assertEquals(Arrays.toString(arrayCorrectSort), Arrays.toString(arrayTestedSort));
    }

    @Test
    void objectIntSortEmpty() {
        Int[] arrayTestedSort = {};
        Int[] arrayCorrectSort = {};
        Sort.sort(arrayTestedSort);
        assertEquals(Arrays.toString(arrayCorrectSort), Arrays.toString(arrayTestedSort));
    }
}