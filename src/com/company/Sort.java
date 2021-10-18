/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo4
 * Fichier : Sort.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 18.10.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier
 * Compilateur : OpenJDK 11
 * ---------------------------
 */
package com.company;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Sort {
    private enum SwitchMethod {
        SWITCH_ARRAY_ELEMENTS,
        SWITCH_INT_VALUES_WITCH_STATIC_METHOD,
        SWITCH_INT_VALUES_WITCH_INSTANCE_METHOD
    }
    private static final SwitchMethod SWITCH_METHOD_FOR_SORTING = SwitchMethod.SWITCH_INT_VALUES_WITCH_INSTANCE_METHOD;

    public static void main(String[] args) {
        if (argsAreValid(args)) {
            Int[] values = new Int[args.length];
            for (int argIndex = 0; argIndex < args.length; argIndex++) {
                values[argIndex] = new Int(convertStringToInt(args[argIndex]));
            }
            bubbleSort(values);
            System.out.println(Arrays.toString(values));
        }
    }

    private static boolean argsAreValid(String[] args) {
        boolean returnValue = true;
        if (args.length < 2) {
            System.out.println("You must provide at least two values.");
            returnValue = false;
        } else {
            Pattern numberRegex = Pattern.compile("[+-]?[0-9]+");
            for (String arg : args) {
                if (!numberRegex.matcher(arg).matches()) {
                    System.out.println("Invalid value : " + arg);
                    returnValue = false;
                }
            }
        }
        return returnValue;
    }

    private static int convertStringToInt(String inputString) {
        String digitsSubString = Character.isDigit(inputString.charAt(0)) ? inputString : inputString.substring(1);
        char[] reversedDigits = new StringBuilder(digitsSubString).reverse().toString().toCharArray();
        int conversionResult = 0;
        for (int digitPosition = 0; digitPosition < reversedDigits.length; digitPosition++)
            conversionResult += (reversedDigits[digitPosition] - 48) * Math.pow(10, digitPosition);
        return inputString.charAt(0) == '-' ? -conversionResult : conversionResult;
    }

    private static void bubbleSort(int[] values) {
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

    private static void bubbleSort(Int[] values) {
        boolean sortingHasProgressed;
        do {
            sortingHasProgressed = false;
            for (int valueIndex = 1; valueIndex < values.length; valueIndex++) {
                if (values[valueIndex].getValue() < values[valueIndex - 1].getValue()) {
                    switch (SWITCH_METHOD_FOR_SORTING) {
                        case SWITCH_ARRAY_ELEMENTS:
                            switchArrayElements(values, valueIndex, valueIndex - 1);
                            break;
                        case SWITCH_INT_VALUES_WITCH_STATIC_METHOD :
                            Int.switchValues(values[valueIndex], values[valueIndex - 1]);
                            break;
                        case SWITCH_INT_VALUES_WITCH_INSTANCE_METHOD:
                            values[valueIndex].switchValues(values[valueIndex - 1]);
                            break;
                    }
                    sortingHasProgressed = true;
                }
            }
        } while (sortingHasProgressed);
    }

    private static void switchArrayElements(Int[] array, int firstIndex, int secondIndex) {
        Int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}