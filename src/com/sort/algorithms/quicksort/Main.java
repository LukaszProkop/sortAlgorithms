package com.sort.algorithms.quicksort;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.sort.algorithms.NewArray.unsortedArray;

public class Main {
    public static void main(String[] args) {
        int[] intArray = unsortedArray(50);
        System.out.println(Arrays.stream(intArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "unsorted array: [", "]")));
        long start = System.nanoTime();

        quickSort(intArray, 0, intArray.length);

        long end = System.nanoTime() - start;
        System.out.println(Arrays.stream(intArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "sorted array: [", "]")));
        System.out.println("sorted time: " + end);
    }

    public static void quickSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int pivotIndex = partition(input, start, end);
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);
    }

    public static int partition(int[] input, int start, int end) {
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {
            while (i < j && input[--j] >= pivot);
            if (i < j) {
                input[i] = input[j];
            }
            while (i < j && input[++i] <= pivot);
            if (i < j) {
                input[j] = input[i];
            }
        }
        input[j] = pivot;
        return j;
    }
}
