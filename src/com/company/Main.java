package com.company;

public class Main {

    public static void main(String[] args) {

        System.out.println("================ test class Int custom ====================");
        Test.testIntClass();

        System.out.println("================ test tableau d'entiers ===================");
        Test.testIntArray(args);

        System.out.println("================ test tableau de Int custom ===============");
        Test.testCustomIntArray(args);

    }
}
