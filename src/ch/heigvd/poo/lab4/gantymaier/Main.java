/*
 * FILE-HEADER----------------
 * Laboratoire : POO - labo4
 * Fichier : Main.java
 * Auteurs : Elliot Ganty et Damien Maier
 * Date : 19.10.2021
 * But : Le but est décrit dans les commentaires ci-dessous décrivant la classe de ce fichier.
 * Compilateur : OpenJDK 11
 * ---------------------------
 */

package ch.heigvd.poo.lab4.gantymaier;

import java.util.Arrays;
import java.util.regex.Pattern;

import static ch.heigvd.poo.lab4.gantymaier.Sort.sort;

/**
 * Classe permettant de réaliser la 3eme partie du laboratoire à savoir le tri d'objets Int tirés
 * des éléments fournis en arguments de la ligne de commande.
 */
public class Main {

    /**
     * Trie et affiche un tableau d'arguments interprétés comme des objets Int.
     *
     * @param args nombres à trier, chaque argument doit être un nombre entier éventuellement précédé
     *             d'un + ou d'un -
     * @author Elliot Ganty et Damien Maier
     */
    public static void main(String[] args) {
        if (argsAreValid(args)) {
            Int[] values = new Int[args.length];
            for (int argIndex = 0; argIndex < args.length; argIndex++) {
                values[argIndex] = new Int(convertStringToInt(args[argIndex]));
            }
            sort(values);
            System.out.println(Arrays.toString(values));
        }
    }

    /**
     * Vérifie l'existence d'au moins un argument et si chaque argument fourni est un entier valide.
     *
     * @param args arguments à tester
     * @return résultat de la vérification
     * @author Elliot Ganty et Damien Maier
     */
    private static boolean argsAreValid(String[] args) {
        if (args.length == 0) {
            System.out.println("You must provide at least one value.");
            return false;
        }
        boolean returnValue = true;
        Pattern numberRegex = Pattern.compile("[+-]?[0-9]+");
        for (String arg : args) {
            if (!numberRegex.matcher(arg).matches()) {
                System.out.println("Invalid value : " + arg);
                returnValue = false;
            }
        }
        return returnValue;
    }

    /**
     * Récupère la valeur entière depuis une chaîne donnée en paramètre.
     *
     * @param inputString argument de la ligne de commande
     * @return valeur entière correspondante
     * @author Elliot Ganty et Damien Maier
     */
    private static int convertStringToInt(String inputString) {
        String digitsSubString = Character.isDigit(inputString.charAt(0)) ? inputString : inputString.substring(1);
        char[] reversedDigits = new StringBuilder(digitsSubString).reverse().toString().toCharArray();
        int conversionResult = 0;

        for (int digitPosition = 0; digitPosition < reversedDigits.length; digitPosition++)
            conversionResult += (reversedDigits[digitPosition] - '0') * Math.pow(10, digitPosition);

        return inputString.charAt(0) == '-' ? -conversionResult : conversionResult;
    }
}
