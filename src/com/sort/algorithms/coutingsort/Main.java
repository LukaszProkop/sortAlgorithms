package com.sort.algorithms.coutingsort;

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

        countingSort(intArray, 1, 1000);

        long end = System.nanoTime() - start;
        System.out.println(Arrays.stream(intArray)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "sorted array: [", "]")));
        System.out.println("sorted time: " + end);
    }

    public static void countingSort(int[] input, int min, int max) {

        int[] countingArray = new int[(max - min) + 1];
        for (int i = 0; i < input.length; i++) {
            countingArray[input[i] - min]++;
        }

        int j = 0;
        for (int i = min; i <= max; i++) {
            while (countingArray[i-min]>0){
                input[j++] = i;
                countingArray[i-min]--;
            }
        }
    }
}
