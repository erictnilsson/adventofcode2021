package com.erictnilsson;

import com.erictnilsson.days.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader();
        var input = reader.readInput("day11");
        var day = new Day11();

        day.puzzleOne(input);
    }
}
