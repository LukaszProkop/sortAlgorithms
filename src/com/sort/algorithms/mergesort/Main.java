package com.sort.algorithms.mergesort;

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

        mergeSort(intArray, 0, intArray.length);

        long end = System.nanoTime() - start;

        System.out.println(Arrays.stream(intArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "sorted array: [", "]")));
        System.out.println("sorted time: " + end);
    }

    public static void mergeSort(int[] input, int start, int end) {
        if (end - start < 2) {
            return;
        }

        int mid = (start + end) / 2;
        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end) {
        if (input[mid - 1] <= input[mid]) {
            return;
        }
        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end) {
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        System.arraycopy(input, i, input, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}
