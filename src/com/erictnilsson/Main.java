package com.erictnilsson;

import com.erictnilsson.day1.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader();
        var input = reader.readInput("day1");
        Day1 day1 = new Day1();
        day1.PuzzleOne(input);

        day1.PuzzleTwo(input);
    }
}
