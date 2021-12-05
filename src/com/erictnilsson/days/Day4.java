package com.erictnilsson.days;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

    public void PuzzleOne(List<String> input) {
        input = input.stream().filter(x -> !x.isBlank()).collect(Collectors.toList());
        var numbers = input.remove(0).split(",");
        var boards = createBoards(input);
        var results = new ArrayList<Result>();
        for (var board : boards) {
            var result = play(board, numbers);
            results.add(result);
        }

        var min = results.stream().min(Comparator.comparingInt(x -> x.round)).get();
        System.out.println(min.sum * min.winningNumber);
        System.out.println("hej");
    }

    record Result(int round, int sum, int winningNumber) {
    }

    private Result play(String[][] board, String[] numbers) {
        for (int n = 0; n < numbers.length; n++) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j].equals(numbers[n])) {
                        board[i][j] = "x";
                        boolean hasWon = checkIfWon(board);
                        if (hasWon) {
                            int sum = getSum(board);
                            int val = Integer.valueOf(numbers[n]);
                            return new Result(n, sum, val);
                        }
                    }
                }
            }
        }
        return null;
    }

    private int getSum(String[][] board) {
        return Arrays.stream(board).map(x -> Arrays.stream(x).filter(y -> !y.equals("x")).mapToInt(Integer::valueOf).sum()).mapToInt(Integer::valueOf).sum();
    }

    private boolean checkIfWon(String[][] board) {
        for (int i = 0; i < board.length; i++) {
            int rowX = 0;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].equals("x")) {
                    rowX++;
                    int colX = 0;
                    for (int foo = i + 1; foo < board.length; foo++) {
                        if (board[foo][j].equals("x")) colX++;
                    }
                    if (colX == 5) return true;
                }
            }
            if (rowX == 5) return true;
        }
        return false;
    }

    private List<String[][]> createBoards(List<String> input) {
        List<String[][]> boards = new ArrayList<>();
        String[][] board = new String[5][5];
        for (int i = 0; i < input.size(); i++) {
            var row = Arrays.stream(input.get(i).split(" ")).filter(x -> !x.isBlank()).toArray(String[]::new);
            board[i % 5] = row;

            if ((i + 1) % 5 == 0) {
                boards.add(board);
                board = new String[5][5];
            }

        }
        return boards;
    }
}
