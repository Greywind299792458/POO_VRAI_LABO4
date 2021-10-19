/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo4
 * Fichier : Sort.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 19.10.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier
 * Compilateur : OpenJDK 11
 * ---------------------------
 */
package ch.heigvd.poo.lab4.gantymaier;

import ch.heigvd.poo.lab4.gantymaier.Int;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Sort {
    private enum SwapMethod {
        SWAP_ARRAY_ELEMENTS,
        SWAP_INT_VALUES_WITH_STATIC_METHOD,
        SWAP_INT_VALUES_WITH_INSTANCE_METHOD
    }
    private static final SwapMethod SWAP_METHOD_FOR_SORTING = SwapMethod.SWAP_INT_VALUES_WITH_INSTANCE_METHOD;



    public static void sort(int[] values) {
        if (values.length >= 2) {
            boolean sortingHasProgressed;
            do {
                sortingHasProgressed = false;
                for (int valueIndex = 1; valueIndex < values.length; valueIndex++) {

                    if (values[valueIndex] < values[valueIndex - 1]) {
                        int temp = values[valueIndex];
                        values[valueIndex] = values[valueIndex - 1];
                        values[valueIndex - 1] = temp;
                        sortingHasProgressed = true;
                    }
                }
            } while (sortingHasProgressed);
        }
    }

    public static void sort(Int[] values) {
        if (values.length >= 2) {
            boolean sortingHasProgressed;
            do {
                sortingHasProgressed = false;
                for (int valueIndex = 1; valueIndex < values.length; valueIndex++) {
                    if (values[valueIndex].getValue() < values[valueIndex - 1].getValue()) {
                        switch (SWAP_METHOD_FOR_SORTING) {
                            case SWAP_ARRAY_ELEMENTS:
                                Int.swapArrayElements(values, valueIndex, valueIndex - 1);
                                break;
                            case SWAP_INT_VALUES_WITH_STATIC_METHOD:
                                Int.swapValues(values[valueIndex], values[valueIndex - 1]);
                                break;
                            case SWAP_INT_VALUES_WITH_INSTANCE_METHOD:
                                values[valueIndex].swapValues(values[valueIndex - 1]);
                                break;
                        }
                        sortingHasProgressed = true;
                    }
                }
            } while (sortingHasProgressed);
        }
    }


}