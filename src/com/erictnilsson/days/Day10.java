package com.erictnilsson.days;

import com.erictnilsson.IDay;

import java.util.List;
import java.util.Stack;

public class Day10 implements IDay {

    public void puzzleOne(List<String> input){
        var score = 0;
        for (var line : input) {
            var stack = new Stack<>();
            var chars = line.split("");
            for (var c : chars) {
                switch (c) {
                    case "{" -> stack.push("}");
                    case "(" -> stack.push(")");
                    case "[" -> stack.push("]");
                    case "<" -> stack.push(">");
                    default -> score += stack.pop().equals(c) ? 0 : getScore(c);
                }
            }
        }
        System.out.println(score);
    }

    @Override
    public void puzzleTwo(List<String> input) {

    }

    private int getScore(String c) {
        return switch (c) {
            case ")" -> 3;
            case "]" -> 57;
            case "}" -> 1197;
            case ">" -> 25137;
            default -> 0;
        };
    }
}
