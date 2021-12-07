package com.erictnilsson.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Day6 {

    public void puzzleOne(List<String> input) {
        var fishies = input
                .stream()
                .flatMapToInt(x -> Arrays.stream(x.split(","))
                        .mapToInt(Integer::valueOf))
                .boxed()
                .collect(Collectors.toList());

        for (int i = 0; i < 80; i++) {
            int size = fishies.size();
            for (int j = 0; j < size; j++) {
                var fish = fishies.get(j);

                if (fish == 0) {
                    fishies.add(8);
                    fish = 6;
                } else fish--;

                fishies.set(j, fish);
            }
        }
        System.out.println(fishies.size());
    }

    public void puzzleTwo(List<String> input) {
        var fishies = input.stream().flatMapToInt(x -> Arrays.stream(x.split(",")).mapToInt(Integer::valueOf)).toArray();

        var birthMap = new HashMap<Integer, Long>() {{
            put(0, 0L);
            put(1, 0L);
            put(2, 0L);
            put(3, 0L);
            put(4, 0L);
            put(5, 0L);
            put(6, 0L);
            put(7, 0L);
            put(8, 0L);
        }};

        for (var fish : fishies)
            birthMap.compute(fish, (k, v) -> ++v);

        for (int day = 0; day < 256; day++) {
            int dueDate = (day + 7) % 9;
            int today = day % 9;

            birthMap.compute(dueDate, (k, v) -> v += birthMap.get(today));
        }
        long sum = birthMap.values().stream().mapToLong(Long::valueOf).sum();
        System.out.println(sum);
    }
}
