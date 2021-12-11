package com.erictnilsson.days;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Day7 {

    public void puzzleOne(String input) {
        var crabs = Stream.of(input.split(",")).mapToInt(Integer::valueOf).boxed().sorted().toList();
        int cost = crabs.stream().mapToInt(c -> Math.abs(c - crabs.get(crabs.size() / 2))).sum();
        System.out.println(cost);
    }
}
