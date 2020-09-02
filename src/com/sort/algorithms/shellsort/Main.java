package com.sort.algorithms.shellsort;

import java.util.Arrays;

import static com.sort.algorithms.NewArray.unsortedArray;

public class Main {
    public static void main(String[] args) {
        int[] intArray = unsortedArray(50);

        System.out.print("unsorted array: [");
        Arrays.stream(intArray).forEach(value -> System.out.print(value + ", "));
        System.out.println("]");

        long start = System.nanoTime();

        for (int gap = intArray.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < intArray.length; i++) {
                int newElement = intArray[i];
                int j = i;
                while (j >= gap && intArray[j - gap] > newElement) {
                    intArray[j] = intArray[j - gap];
                    j -= gap;
                }
                intArray[j] = newElement;
            }
        }

        long end = System.nanoTime() - start;

        System.out.print("sorted array: [");
        Arrays.stream(intArray).forEach(value -> System.out.print(value + ", "));
        System.out.println("]\nsorted time: " + end);
    }
}
