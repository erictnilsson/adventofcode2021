package com.erictnilsson.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

    private record Result(int winningRound, int sum, int winningNumber) {
    }

    private int[] getCallingNumbers(String numbers) {
        return Arrays.stream(numbers.split(",")).mapToInt(Integer::valueOf).toArray();
    }

    public void puzzleOne(List<String> input) {
        List<Result> results = play(input);
        Result winner = results.stream().min(Comparator.comparingInt(x -> x.winningRound)).get();

        System.out.println(winner.sum * winner.winningNumber);
    }

    public void puzzleTwo(List<String> input) {
        List<Result> results = play(input);
        Result loser = results.stream().max(Comparator.comparingInt(x -> x.winningRound)).get();

        System.out.println(loser.sum * loser.winningNumber);
    }

    private List<Result> play(List<String> input) {
        int[] callingNumbers = getCallingNumbers(input.remove(0));
        List<Result> results = new ArrayList<>();

        int[][] board = new int[5][5];
        for (int i = 1; i <= input.size(); i++) {
            if (i == input.size() || input.get(i).isBlank()) {
                var result = playBoard(board, callingNumbers);
                results.add(result);

                board = new int[5][5]; // reset board
            } else {
                int[] row = Arrays
                        .stream(input.get(i).split(" "))
                        .filter(x -> !x.isBlank())
                        .mapToInt(Integer::valueOf)
                        .toArray();

                board[(i - 1) % 5] = row;
            }
        }
        return results;
    }

    private Result playBoard(int[][] board, int[] callingNumbers) {
        int sum = Arrays.stream(board)
                .flatMapToInt(Arrays::stream)
                .sum();

        for (int i = 0; i < callingNumbers.length; i++) {
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[row].length; col++) {
                    // mark
                    if (board[row][col] == callingNumbers[i]) {
                        sum -= board[row][col]; // subtract of board's sum
                        board[row][col] = -1; // mark cell
                    }

                    // check winning
                    if (rowWon(board[row]) || colWon(board, col)) {
                        return new Result(i, sum, callingNumbers[i]);
                    }

                }
            }
        }
        return null;
    }

    private boolean rowWon(int[] row) {
        return Arrays.stream(row).noneMatch(x -> x > 0);
    }

    private boolean colWon(int[][] board, int col) {
        return Arrays.stream(board).map(x -> x[col]).noneMatch(x -> x > 0);
    }
}
