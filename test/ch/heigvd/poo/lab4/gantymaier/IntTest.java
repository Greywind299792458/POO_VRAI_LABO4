/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo4
 * Fichier : IntTest.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 19.10.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier
 * Compilateur : OpenJDK 11
 * ---------------------------
 */

package ch.heigvd.poo.lab4.gantymaier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Teste la classe Int en créant des objets en les échangeant ou en échangeant leurs valeurs respectives.
 */
class IntTest {
    Int int1;
    Int int2;

    @BeforeEach
    void setUp() {
        int1 = new Int(42);
        int2 = new Int(57);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getValue() {
        assertEquals(int1.getValue(), 42);
    }

    @Test
    void setValue() {
        int1.setValue(100);
        assertEquals(int1.getValue(), 100);
    }

    @Test
    void testToString() {
        assertEquals(int1.toString(), "42");
    }

    @Test
    void staticSwapValues() {
        Int.swapValues(int1, int2);
        assertEquals(int1.getValue(), 57);
        assertEquals(int2.getValue(), 42);
    }

    @Test
    void instanceSwapValues() {
        int1.swapValues(int2);
        assertEquals(int1.getValue(), 57);
        assertEquals(int2.getValue(), 42);
    }
}