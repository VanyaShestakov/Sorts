package com.company;
public class Sorts {

    private static void swap(double[] array, int firstIndex, int secondIndex) {
        double temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }

    private static int getMax(int[] array) {
        int maxValue = array[0];
        for (int element: array) {
            if (element > maxValue) {
                maxValue = element;
            }
        }
        return  maxValue;
    }

    //Сортировка простыми вставки
    public static void doInsertionSort(double[] array) {
        for (int i = 0; i < array.length; i++){
            double current = array[i];
            int j = i;
            while(current < array[j - 1] && j > 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
        }
    }

    //Сортировка пузырьком
    public static void doBubbleSort(double[] array) {
        boolean isNotSorted = true;
        while (isNotSorted) {
            isNotSorted = false;
            for (int i = 0; i < array.length -1; i++) {
                if (array[i] > array[i + 1]) {
                    isNotSorted = true;
                    swap(array, i, i + 1);
                }
            }
        }
    }

    //Шейкерная сортировка
    public static void doShakerSort(double[] array) {
        int leftLimit = 0;
        int rightLimit = array.length - 1;
        while (leftLimit <= rightLimit) {
            for (int i = leftLimit; i < rightLimit; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i + 1, i);
                }
            }
            rightLimit--;
            for (int i = rightLimit; i > leftLimit; i--) {
                if (array[i] < array[i - 1]) {
                    swap(array, i - 1, i);
                }
            }
            leftLimit++;
        }
    }

    //Сортировка выбором
    public static void doSelectionSort(double[] array) {
        for (int i = 0; i < array.length; i++) {
            int indexOfMin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[indexOfMin]) {
                    indexOfMin = j;
                }
                swap(array, indexOfMin, i);
            }
        }
    }

    //Поразрядная сортировка
    public static void doRadixSort(int[] array){
        int length = array.length;
        int digitPlace = 1;
        int[] result = new int [length];
        int largestNum = getMax(array);

        while (largestNum / digitPlace > 0){
            int[] baskets = new int [10];
            for (int i = 0; i < 10; i++){
                baskets[i] = 0;
            }
            for (int i = 0; i < array.length; i++) {
                baskets[(array[i] / digitPlace) % 10]++;
            }
            for (int i = 1; i < 10; i++) {
                baskets[i] += baskets[i - 1];
            }
            for (int i = array.length - 1; i > -1; i--) {
                result[baskets[(array[i] / digitPlace) % 10 ] - 1] = array[i];
                baskets[(array[i] / digitPlace) % 10 ]--;
            }
            digitPlace += 10;
        }
    }
}
