package l1_file_sorter;

import l1_file_sorter.utils.DataGenerator;
import l1_file_sorter.utils.FileSorter;

import java.io.IOException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {

        Path inputPath = Path.of("in.txt");
        Path outputPath = Path.of("out.txt");

        DataGenerator.generateFile(inputPath);
        FileSorter.sortFile(inputPath, outputPath);
    }
}