package com.company;

import java.util.Arrays;

public class Test {

    public static void testIntArray(String[] args) {
        if(args.length <= 0) {
            System.out.println("pas d'arguments");
        } else {
            int[] tab = new int[(args.length)];

            for(int i = 0; i < args.length; ++i) {
                tab[i] = extractIntFromString(args[i]);
            }
            System.out.println("avant :");
            Test.printTab(tab);
            Sort.sortIntegers(tab);
            System.out.println("apres :");
            Test.printTab(tab);
        }
    }

    public static void testCustomIntArray(String[] args) {
        if(args.length <= 0) {
            System.out.println("pas d'arguments");
        } else {
            Int[] tab = new Int[(args.length)];

            for(int i = 0; i < args.length; ++i) {
                tab[i] = new Int(extractIntFromString(args[i]));
            }

            System.out.println("avant :");
            Int.printTabInt(tab);
            Sort.sortCustomInt(tab);
            System.out.println("apres :");
            Int.printTabInt(tab);
        }
    }

    public static void testIntClass() {
        System.out.println("---------- test creation d'instances ===============");
        Int i = new Int(2);
        System.out.println("i = " + i.get());
        i.set(5);
        System.out.println("i = " + i.get());

        System.out.println("---------- test swap valeur objet courant ----------");

        Int a = new Int(10);
        Int b = new Int(2);

        System.out.println(a.print());
        System.out.println(b.print());
        System.out.println("Changement");
        a.swap(b);
        System.out.println(a.print());
        System.out.println(b.print());

        System.out.println("---------- test swap variables d'un tableau --------");

        Int[] tab = new Int[]{new Int(10),new Int(2), new Int(4)};

        Int.printTabInt(tab);
        System.out.println("Changement");
        tab = Int.swapVariables(tab, 0, 1);
        Int.printTabInt(tab);

        System.out.println("---------- test swap valeurs de 2 Int ---------------");

        a = new Int(10);
        b = new Int(2);

        System.out.println(a.print());
        System.out.println(b.print());
        System.out.println("Changement");
        Int.swapValues(a, b);
        System.out.println(a.print());
        System.out.println(b.print());
    }

    public static int extractIntFromString(String arg) {

        int index = 0;
        int number = 0;
        boolean negNumber = false;

        if(arg.charAt(0) == '-') {
            negNumber = true;
            index = 1;
        }

        for(;index < arg.length(); ++index) {
            if(Character.isDigit(arg.charAt(index))) {

                number *= 10;
                number += arg.charAt(index) - '0';

                /*
                 *   0 = 48 => 4 = '4' - '0' => 52 - 48 = 4
                 *
                 *   12 =>
                 *
                 *   0 * 10 = 0
                 *   0 += 1 = 1 =>   i = 1 ok
                 *   1 * 10 = 10
                 *   10 + 2 = 12  => i = 2 stop
                 */
            } else {
                break; // comme le buffer d'entrée en C/C++
            }
        }
        return negNumber ? -number : number;
    }

    public static void printTab(int[] tab) {
        System.out.print("[");
        for (int j : tab) {
            System.out.print(j + " ");
        }
        System.out.print("] \n");
    }
}
