package com.erictnilsson;

import com.erictnilsson.days.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader();
        var input = reader.readInput("day6");
        var day6 = new Day6();

        day6.puzzleOne(input);
        day6.puzzleTwo(input);
    }
}
