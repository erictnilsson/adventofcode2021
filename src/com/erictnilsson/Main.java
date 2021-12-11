package com.erictnilsson;

import com.erictnilsson.days.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        InputReader reader = new InputReader();
        var input = reader.readInput("day7");
        var day7 = new Day7();

        day7.puzzleOne(input.get(0));
    }
}
