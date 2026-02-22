package l1_file_sorter.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileSorter {

    public static void sortFile(Path inputPath, Path outputPath) {
        try {
            List<String> rows = Files.readAllLines(inputPath);
            List<String> sortedRows = new ArrayList<>();

            for (String row : rows) {
                String[] elements = row.split("\t");
                List<String> elementsList = new ArrayList<>(Arrays.asList(elements));
                elementsList.sort(FileSorter::compareElements);
                sortedRows.add(String.join("\t", elementsList));
            }

            sortedRows.sort((row1, row2) -> {
                String[] column1 = row1.split("\t");
                String[] column2 = row2.split("\t");

                for (int i = 0; i < column1.length; i++) {
                    int resultOfCompare = compareElements(column1[i], column2[i]);
                    if (resultOfCompare != 0) return  resultOfCompare;
                }
                return 0;
            });

            Files.write(outputPath, sortedRows);
            System.out.println("Строки отсортированы!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int compareElements(String s1, String s2) {
        boolean isDigit1 = Character.isDigit(s1.charAt(0));
        boolean isDigit2 = Character.isDigit(s2.charAt(0));

        if (!isDigit1 && isDigit2) return -1;
        if (isDigit1 && !isDigit2) return 1;
        if (isDigit1 && isDigit2) {
            return Integer.compare(Integer.parseInt(s1), Integer.parseInt(s2));
        }
        return s1.compareTo(s2);
    }
}
