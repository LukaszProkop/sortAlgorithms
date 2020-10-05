package com.sort.algorithms.radixsort;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.sort.algorithms.NewArray.unsortedArray;

public class Main {
    public static void main(String[] args) {
        int[] intArray = unsortedArray(6);
        System.out.println(Arrays.stream(intArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "unsorted array: [", "]")));
        long start = System.nanoTime();

        radixsort(intArray, 10, 4);

        long end = System.nanoTime() - start;
        System.out.println(Arrays.stream(intArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "sorted array: [", "]")));
        System.out.println("sorted time: " + end);
    }

    public static void radixsort(int[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            radixSingleSort(input, i, radix);
        }
    }

    public static void radixSingleSort(int[] input, int position, int radix) {
        int numItems = input.length;
        int[] countArray = new int[radix];

        for (int value : input) {
            countArray[getDigit(position, value, radix)]++;
        }

        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];
        for (int tempIndex = numItems - 1; tempIndex>=0; tempIndex--){
            temp[--countArray[getDigit(position, input[tempIndex], radix)]] = input[tempIndex];
        }

        for (int tempIndex = 0; tempIndex<numItems; tempIndex++){
            input[tempIndex] = temp[tempIndex];
        }
    }

    public static int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(10, position) % radix;
    }
}
