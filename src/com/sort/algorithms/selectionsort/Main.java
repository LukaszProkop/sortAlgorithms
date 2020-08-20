package com.sort.algorithms.selectionsort;

import com.sort.algorithms.NewArray;

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
            int largest = 0;
            for (int i = 1; i <= lastUnsortedIndex; i++) {
                if(intArray[i] > intArray[largest]){
                    largest = i;
                }
            }
            swap(intArray, largest, lastUnsortedIndex);
        }

        long end = System.nanoTime() - start;

        System.out.print("sorted array: [");
        Arrays.stream(intArray).forEach(value -> System.out.print(value + ", "));
        System.out.println("]\nsorted time: " + end);
    }
}
