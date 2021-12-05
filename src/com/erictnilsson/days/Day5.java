package com.erictnilsson.days;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Day5 {
    public void puzzleOne(List<String> input) {
        var lines = toLines(input);

        Map<Point, Integer> pointMap = new HashMap<>();
        for (var line : lines)
            traceLine(line, pointMap);

        System.out.println(pointMap.entrySet().stream().filter(x -> x.getValue() > 1).count());
    }

    private void traceLine(Line line, Map<Point, Integer> pointMap) {
        int delta;
        if (line.isHorizontal()) {
            delta = line.b.x - line.a.x;
            for (int i = 0; i <= delta; i++) {
                var point = new Point(line.a.x + (delta - i), line.a.y);
                if (pointMap.containsKey(point))
                    pointMap.compute(point, (key, val) -> ++val);
                else
                    pointMap.put(point, 1);

            }
        } else if (line.isVertical()) {
            delta = line.b.y - line.a.y;
            for (int i = 0; i <= delta; i++) {
                var point = new Point(line.a.x, line.a.y + (delta - i));
                if (pointMap.containsKey(point))
                    pointMap.compute(point, (key, val) -> ++val);
                else
                    pointMap.put(point, 1);
            }
        }
    }


    private Line[] toLines(List<String> input) {
        return input
                .stream()
                .map(x -> x.split(" -> "))
                .map(x -> Arrays.stream(x).map(y -> Arrays.stream(y.split(",")).mapToInt(Integer::valueOf).toArray()))
                .map(x -> x.map(y -> new Point(y[0], y[1])).toArray(Point[]::new))
                .map(x -> new Line(x[0], x[1]))
                .filter(x -> x.isHorizontal() ^ x.isVertical())
                .toArray(Line[]::new);
    }

    private record Line(Point a, Point b) {
        public Line {
            /*
            To ensure that smaller -> higher, eg:
                0,0 -> 0,9 instead of 0,9 -> 0,0
             */
            if (isHorizontal(a, b)) {
                Point start = (a.x <= b.x) ? a : b;
                Point end = (start == a) ? b : a;
                a = start;
                b = end;
            } else if (isVertical(a, b)) {
                Point start = (a.y <= b.y) ? a : b;
                Point end = (start == a) ? b : a;
                a = start;
                b = end;
            }

        }

        boolean isHorizontal() {
            return a.y == b.y;
        }

        private boolean isHorizontal(Point a, Point b) {
            return a.y == b.y;
        }

        boolean isVertical() {
            return a.x == b.x;
        }

        private boolean isVertical(Point a, Point b) {
            return a.x == b.x;
        }
    }
}
