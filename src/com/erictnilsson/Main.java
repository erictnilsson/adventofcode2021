package com.erictnilsson;

import com.erictnilsson.days.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader();
        var input = reader.readInput("day9");
        var day9 = new Day9();

        day9.puzzleOne(input);
    }
}
