package com.erictnilsson.day1;

import java.util.List;

public class Day1 {

    public void PuzzleOne(List<String> input) {
        int[] arr = toIntArray(input);
        int increments = 1;
        for (int i = 1, j = 2; j < arr.length; i++, j++) {
            if (arr[j] > arr[i]) increments++;
        }

        System.out.println(increments);
    }

    public void PuzzleTwo(List<String> input) {
        int[] arr = toIntArray(input);
        int increments = 0;
        for (int i = 0, j = 3; j < arr.length; i++, j++) {
            if (arr[j] > arr[i]) increments++;
        }
        System.out.println(increments);
    }

    private int[] toIntArray(List<String> stringList) {
        return stringList.stream().mapToInt(x -> Integer.parseInt(x)).toArray();
    }
}
