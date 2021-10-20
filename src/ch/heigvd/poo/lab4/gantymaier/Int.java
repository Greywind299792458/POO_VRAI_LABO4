/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo4
 * Fichier : Int.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 19.10.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier.
 * Compilateur : OpenJDK 11
 * ---------------------------
 */

package ch.heigvd.poo.lab4.gantymaier;

/**
 * Classe encapsulant le type primitif int.
 */
public class Int {
    private int value;

    /**
     * Echange la valeur de l'attribut 'value' de 2 instances.
     *
     * @param first  premier  objet Int
     * @param second deuxième objet Int
     * @author Elliot Ganty et Damien Maier
     */
    public static void swapValues(Int first, Int second) {
        int temp = first.value;
        first.value = second.value;
        second.value = temp;
    }

    /**
     * Echange deux éléments d'un tableau d'objets Int.
     *
     * @param array       tableau contenant les objets
     * @param firstIndex  1er  element à échanger
     * @param secondIndex 2eme element à échanger
     * @author Elliot Ganty et Damien Maier
     */
    public static void swapArrayElements(Int[] array, int firstIndex, int secondIndex) {
        Int temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    /**
     * Constructeur avec une valeur entière correspondant à l'attribut 'value'.
     *
     * @param value valeur fournie
     * @author Elliot Ganty et Damien Maier
     */
    public Int(int value) {
        this.value = value;
    }

    /**
     * Echange la valeur de l'objet courant avec la valeur d'un autre objet fourni en paramètre.
     *
     * @param other autre objet avec lequel échanger l'élément courant
     * @author Elliot Ganty et Damien Maier
     */
    public void swapValues(Int other) {
        swapValues(this, other);
        /*int temp = value;
        value = other.value;
        other.value = temp;*/
    }

    /**
     * Permet de récupérer la valeur de l'attribut 'value'.
     *
     * @return valeur de l'attribut
     * @author Elliot Ganty et Damien Maier
     */
    public int getValue() {
        return value;
    }

    /**
     * Permet de modifier l'attribut 'value'.
     *
     * @param value nouvelle valeur pour l'attribut
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Redéfinition de la méthode toString() de la classe Object.
     *
     * @return la valeur de l'attribut 'value' sous forme de chaîne
     * @author Elliot Ganty et Damien Maier
     */
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
