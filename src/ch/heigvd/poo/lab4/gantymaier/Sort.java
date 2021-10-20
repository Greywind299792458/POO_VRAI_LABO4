/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo4
 * Fichier : Sort.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 19.10.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier.
 * Compilateur : OpenJDK 11
 * ---------------------------
 */
package ch.heigvd.poo.lab4.gantymaier;

/**
 * Fournit des fonctions permettant de trier un tableau d'entiers ou d'objets Int.
 */
public class Sort {

    private enum SwapMethod {
        SWAP_ARRAY_ELEMENTS,
        SWAP_INT_VALUES_WITH_STATIC_METHOD,
        SWAP_INT_VALUES_WITH_INSTANCE_METHOD
    }

    /**
     * Indique la méthode de la classe Int à appeler lors de l'échange de deux éléments
     * pendant l'exécution de <code>sort(Int[] values)</code>
     */
    private static final SwapMethod SWAP_METHOD_FOR_SORTING = SwapMethod.SWAP_INT_VALUES_WITH_INSTANCE_METHOD;

    /**
     * Trie un tableau d'entiers selon le tri à bulles.
     *
     * @param values tableau d'entiers à trier
     * @author Elliot Ganty et Damien Maier
     */
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

    /**
     * Trie un tableau de Int selon le tri à bulles.
     *
     * @param values tableau d'objets de type Int à trier
     * @author Elliot Ganty et Damien Maier
     */
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