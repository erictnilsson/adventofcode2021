package com.erictnilsson.days;

import com.erictnilsson.IDay;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Day11 implements IDay {

    private record Coordinate(int i, int j) {
    }

    @Override
    public void puzzleOne(List<String> input) {
        var map = createMap(input);
        int steps = 0;
        int flashCount = 0;
        while (++steps <= 100) {
            var flashed = new HashSet<Coordinate>();
            increase(map);

            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] > 9)
                        flash(map, i, j, flashed);
                }
            }
            flashed.forEach(v -> map[v.i][v.j] = 0);
            flashCount += flashed.size();
        }
        System.out.println(flashCount);


    }

    private void increase(int[][] map) {
        for (int i = 0; i < map.length; i++)
            for (int j = 0; j < map[i].length; j++)
                map[i][j]++;
    }

    private void flash(int[][] map, int i, int j, HashSet flashed) {
        var coord = new Coordinate(i, j);
        if (flashed.contains(coord))
            return;

        flashed.add(coord);
        map[i][j] = 0;

        for (int y = -1; y < 2; y++) {
            for (int x = -1; x < 2; x++) {
                int xj = x + j, yi = y + i;
                if ((x == 0 && y == 0) || yi < 0 || yi >= map.length || xj < 0 || xj >= map[yi].length)
                    continue;

                ++map[yi][xj];
                if (map[yi][xj] > 9)
                    flash(map, yi, xj, flashed);
            }
        }
    }

    private int[][] createMap(List<String> input) {
        return input.stream().map(row -> Arrays.stream(row.split("")).mapToInt(Integer::valueOf).toArray()).toArray(int[][]::new);
    }

    @Override
    public void puzzleTwo(List<String> input) {

    }
}
