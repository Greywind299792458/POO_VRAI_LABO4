/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo4
 * Fichier : MainTest.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 19.10.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier.
 * Compilateur : OpenJDK 11
 * ---------------------------
 */

package ch.heigvd.poo.lab4.gantymaier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Teste le tri de valeurs récupérées en arguments de la ligne de commande
 * interprétées comme des entiers ou des objets Int.
 */
class MainTest {
    private final ByteArrayOutputStream printedContent = new ByteArrayOutputStream();


    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(printedContent));
    }

    @Test
    void mainWithMultipleValues() {
        Main.main(new String[]{"1", "2", "+42", "-1337", "42"});
        assertEquals("[-1337, 1, 2, 42, 42]" + System.lineSeparator(), printedContent.toString());
    }

    @Test
    void mainWithOneValue() {
        Main.main(new String[]{"+1"});
        assertEquals("[1]" + System.lineSeparator(), printedContent.toString());
    }

    @Test
    void mainWithoutValues() {
        Main.main(new String[]{});
        assertEquals("You must provide at least one value." + System.lineSeparator(), printedContent.toString());
    }
}