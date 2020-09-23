package com.sort.algorithms;

import java.util.HashSet;
import java.util.Random;
import java.util.stream.Collectors;

public class NewArray {

    public static int[] unsortedArray(int numberOfElements) {

        int[] intArray = new int[numberOfElements];

        HashSet<Integer> randomSet = new HashSet<>();
        Random r = new Random();

        randomSet.addAll(r
                .ints(numberOfElements, 1, 1000)
                .boxed()
                .collect(Collectors.toSet()));

        return intArray = randomSet.stream()
                .mapToInt(Number::intValue)
                .toArray();
    }
}
