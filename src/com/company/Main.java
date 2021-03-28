package com.company;

import java.util.Scanner;

public class Main {
    public static Scanner sysScan = new Scanner(System.in);

    public static int inputLength() {
        int length = 0;
        boolean isIncorrect;
        System.out.println("Enter the length of the array (from 1 to 20)");
        do {
            isIncorrect = false;
            try {
                length = Integer.parseInt(sysScan.nextLine());
            } catch (Exception e) {
                System.out.println("Incorrect input!\nEnter the integer");
                isIncorrect = true;
            }

            if (!isIncorrect && (length < 1 || length > 20)) {
                System.out.println("Incorrect input!\nEnter the length of the range from 1 to 20");
                isIncorrect = true;
            }
        } while (isIncorrect);
        return length;
    }

    public static void inputArray(double[] array) {
        boolean isIncorrect;
        for (int i = 0; i < array.length; i++) {
            do {
                isIncorrect = false;
                System.out.println("Enter the array element at number " + (i + 1));
                try {
                    array[i] = Double.parseDouble(sysScan.nextLine());
                } catch (Exception e) {
                    System.out.println("Incorrect input!\nEnter the number");
                    isIncorrect = true;
                }
            } while (isIncorrect);
        }
    }

    public static void printArray(double[] array) {
        for (double element : array) {
            System.out.print(element + "; ");
        }
        System.out.println("\n");
    }

    public static void chooseTypeOfSort(double[] array) {
        final int INSERTION = 1;
        final  int BUBBLE = 2;
        final int SHAKER = 3;
        final int SELECTION = 4;
        System.out.println("""
                1. Insertion sort
                2. Bubble sort
                3. Shaker sort
                4. Selection sort
                Choose type of sort:""");
        int choice = inputChoice();

        switch (choice) {
            case INSERTION:
                Sorts.doInsertionSort(array);
                return;
            case BUBBLE:
                Sorts.doBubbleSort(array);
                return;
            case SHAKER:
                Sorts.doShakerSort(array);
                return;
            case SELECTION:
                Sorts.doSelectionSort(array);
                return;
        }
    }

    public static int inputChoice() {
        int choice = 0;
        boolean isIncorrect;
        do {
            isIncorrect = false;
            try {
                choice = Integer.parseInt(sysScan.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Enter the integer number!");
                isIncorrect = true;
            }
            if (!isIncorrect && (choice < 1 || choice > 4)) {
                System.err.println("Choose from 1 to 5!");
                isIncorrect = true;
            }
        } while (isIncorrect);
        return choice;
    }

    public static void main(String[] args) {
        int length = inputLength();
	    double[] array = new double[length];
	    inputArray(array);
	    System.out.println("Source arr:");
	    printArray(array);
	    chooseTypeOfSort(array);
	    printArray(array);
	    sysScan.close();
    }
}
