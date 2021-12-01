package com.erictnilsson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputReader {
    public List<String> readInput(String input) throws IOException {
        var reader = new BufferedReader(new FileReader("src/com/erictnilsson/input/" + input + ".txt"));
        var data = new ArrayList<String>();
        String s;
        while ((s = reader.readLine()) != null) {
            data.add(s);
        }
        reader.close();

        return data;
    }
}
