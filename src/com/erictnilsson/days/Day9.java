package com.erictnilsson.days;

import java.util.Arrays;
import java.util.List;

public class Day9 {
    private int[][] heightMap;

    public void puzzleOne(List<String> input) {
        heightMap = createHeightMap(input);
        int riskLevel = 0;

        for (int i = 0; i < heightMap.length; i++)
            for (int j = 0; j < heightMap[i].length; j++)
                if (lookLeft(i, j) && lookUp(i, j) && lookRight(i, j) && lookDown(i, j))
                    riskLevel += heightMap[i][j] + 1;
        
        System.out.println(riskLevel);
    }

    private boolean lookLeft(int i, int j) {
        return j <= 0 || heightMap[i][j - 1] > heightMap[i][j];
    }

    private boolean lookRight(int i, int j) {
        return j >= (heightMap[0].length - 1) || heightMap[i][j + 1] > heightMap[i][j];
    }

    private boolean lookUp(int i, int j) {
        return i <= 0 || heightMap[i - 1][j] > heightMap[i][j];
    }

    private boolean lookDown(int i, int j) {
        return i >= (heightMap.length - 1) || heightMap[i + 1][j] > heightMap[i][j];
    }

    private int[][] createHeightMap(List<String> input) {
        return input.stream().map(row -> Arrays.stream(row.split("")).mapToInt(Integer::valueOf).toArray()).toArray(int[][]::new);
    }

}
