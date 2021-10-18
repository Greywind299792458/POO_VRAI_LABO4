package com.company;

public class Sort {

    public static void sortIntegers(int[] tab) {

        for(int i = 0; i < tab.length - 1; ++i) {
            for(int j = 1; j < tab.length - i; ++j) {
                if(tab[j-1] > tab[j]) {
                    int tmp = tab[j];
                    tab[j] = tab[j-1];
                    tab[j-1] = tmp;
                }
            }
        }
    }

    public static void sortCustomInt(Int[] tab) {

        for(int i = 0; i < tab.length - 1; ++i) {
            for(int j = 1; j < tab.length - i; ++j) {
                if(tab[j-1].get() > tab[j].get()) {
                    tab = Int.swapVariables(tab, j-1, j);
                }
            }
        }
    }
}
