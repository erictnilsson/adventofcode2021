package com.erictnilsson;

import com.erictnilsson.days.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader();
        var input = reader.readInput("day5");
        var day5 = new Day5();

        day5.puzzleOne(input);
    }
}
