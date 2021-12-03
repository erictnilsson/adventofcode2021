package com.erictnilsson;

import com.erictnilsson.day1.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader();
        var input = reader.readInput("day3");
        var day3 = new Day3();

        day3.PuzzleOne(input);
        day3.PuzzleTwo(input.toArray(new String[0]));
    }
}
