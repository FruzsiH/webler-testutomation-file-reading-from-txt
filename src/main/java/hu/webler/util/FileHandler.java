package hu.webler.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static List<String[]> readTxtFile(String filePath, String delimiter) {
        List<String[]> elements = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] lines = line.split(delimiter);
                elements.add(lines);
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return elements;
    }

    private FileHandler() {

    }
}
