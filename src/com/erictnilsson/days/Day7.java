package com.erictnilsson.days;

import com.erictnilsson.IDay;

import java.util.List;
import java.util.stream.Stream;

public class Day7 implements IDay {

    public void puzzleOne(List<String> input) {
        var crabs = Stream.of(input.get(0).split(",")).mapToInt(Integer::valueOf).boxed().sorted().toList();
        int cost = crabs.stream().mapToInt(c -> Math.abs(c - crabs.get(crabs.size() / 2))).sum();
        System.out.println(cost);
    }

    @Override
    public void puzzleTwo(List<String> input) {

    }
}
