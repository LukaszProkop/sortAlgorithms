package com.sort.algorithms.insertionsort;

import java.util.Arrays;

import static com.sort.algorithms.NewArray.unsortedArray;
import static com.sort.algorithms.Swap.swap;

public class Main {
    public static void main(String[] args) {
        int[] intArray = unsortedArray(50);

        System.out.print("unsorted array: [");
        Arrays.stream(intArray).forEach(value -> System.out.print(value + ", "));
        System.out.println("]");

        long start = System.nanoTime();

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < intArray.length; firstUnsortedIndex++) {
            int newElement = intArray[firstUnsortedIndex];
            int i;
            for (i = firstUnsortedIndex; i > 0 && intArray[i - 1] > newElement; i--) {
                intArray[i] = intArray[i - 1];
            }
            intArray[i] = newElement;
        }

        long end = System.nanoTime() - start;

        System.out.print("sorted array: [");
        Arrays.stream(intArray).forEach(value -> System.out.print(value + ", "));
        System.out.println("]\nsorted time: " + end);
    }
}
