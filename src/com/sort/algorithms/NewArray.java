package com.sort.algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class NewArray {

    public static int[] unsortedArray(int numberOfElements){

        int[] intArray = new int[numberOfElements];

        HashSet<Integer> randomSet = new HashSet<>();
        Random r = new Random();


        for (int a = 0; a < intArray.length; a++) {
            randomSet.add(r.nextInt(1000));
        }

        return intArray =  randomSet.stream()
                .mapToInt(Number::intValue)
                .toArray();
    }
}
