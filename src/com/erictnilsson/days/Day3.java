package com.erictnilsson.days;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Day3 {

    public void PuzzleOne(List<String> input) {
        int[] arr = new int[input.get(0).length()];
        var gammaStr = new StringBuilder();
        var epsilonStr = new StringBuilder();

        for (var str : input) {
            for (int i = 0; i < str.length(); i++) {
                var bit = str.charAt(i) - '0'; // ASCII trickery to get the literal int value of char
                arr[i] += (bit == 0) ? -1 : 1; // number of 1s per position
            }
        }

        for (int j : arr) {
            gammaStr.append((j > 0) ? "1" : "0");
            epsilonStr.append((j > 0) ? "0" : "1");
        }

        int gamma = Integer.parseInt(gammaStr.toString(), 2);
        int epsilon = Integer.parseInt(epsilonStr.toString(), 2);

        System.out.println(gamma * epsilon);
    }

    public void PuzzleTwo(final String[] input) {
        int oxygenGeneratorRating = findRating(input, 0, (zeroes) -> (zeroes <= 0) ? '1' : '0');
        int co2ScrubberRating = findRating(input, 0, (zeroes) -> (zeroes <= 0) ? '0' : '1');

        System.out.println(oxygenGeneratorRating * co2ScrubberRating);
    }

    private int findRating(final String[] input, final int i, final Function<Integer, Character> rule) {
        if (input.length == 1) return Integer.parseInt(input[0], 2);

        int zeroesCounter = Arrays
                .stream(input)
                .mapToInt(str -> ((str.charAt(i) - '0') == 0 ? 1 : -1)) // ASCII trickery to get the literal int value of char
                .sum();

        char bit = rule.apply(zeroesCounter);

        String[] output = Arrays
                .stream(input)
                .filter(str -> str.charAt(i) == bit)
                .toArray(String[]::new);

        return findRating(output, i + 1, rule);
    }
}
