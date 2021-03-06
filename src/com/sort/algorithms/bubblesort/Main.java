package com.sort.algorithms.bubblesort;

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

        for (int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i = 0; i < lastUnsortedIndex; i++) {
                if (intArray[i] > intArray[i + 1]) {
                    swap(intArray, i, i + 1);
                }
            }
        }

        long end = System.nanoTime() - start;

        System.out.print("sorted array: [");
        Arrays.stream(intArray).forEach(value -> System.out.print(value + ", "));
        System.out.println("]\nsorted time: " + end);
    }
}
