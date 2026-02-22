package l1_file_sorter.utils;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataGenerator {
    public static void generateFile(Path path) {
        String[] letters = {"a", "b", "c", "d", "e"};
        String[] digits = {"1", "2", "3", "4", "5"};
        Random random = new Random();

        List<String> rows = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < 5; j++) {
                String let = letters[random.nextInt(letters.length)] + "\t";
                String dig = digits[random.nextInt(digits.length)] + "\t";

                sb.append(let).append(dig);
            }
            rows.add(sb.toString().trim());
        }
        try {
            Files.write(path, rows);
            System.out.println("Исходный файл создан!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}