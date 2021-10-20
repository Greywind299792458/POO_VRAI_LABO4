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
     * @param inputString chaîne de caractères représentant un nombre entier
     * @return valeur entière correspondante
     * @author Elliot Ganty et Damien Maier
     */
    private static int convertStringToInt(String inputString) {
        // si il y a un + ou un - au début du string, on récupère le sous string qui ne contient que les chiffres
        String digitsSubString = Character.isDigit(inputString.charAt(0)) ? inputString : inputString.substring(1);
        // On calcule la valeur du nombre représenté par le string en parcourant les chiffres à l'envers (du chiffre
        // de poids faible au chiffre de poids fort). On utilise le fait que chaque chiffre désigne un multiple d'une
        // puissance de 10. Par exemple "234" donne 4*10^0 + 3*10^1 + 2*10^2
        char[] reversedDigits = new StringBuilder(digitsSubString).reverse().toString().toCharArray();
        int conversionResult = 0;

        for (int digitPosition = 0; digitPosition < reversedDigits.length; digitPosition++)
            // - '0' permet d'obtenir la valeur numérique représentée par un caractère, parce que la soustraction se
            // fait sur les valeurs ASCII des caractères
            conversionResult += (reversedDigits[digitPosition] - '0') * Math.pow(10, digitPosition);

        return inputString.charAt(0) == '-' ? -conversionResult : conversionResult;
    }
}
