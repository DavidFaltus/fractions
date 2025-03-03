package pro1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File inputDir = new File("C:/data/input");
        File outputDir = new File("C:/data/output");

        if (!outputDir.exists()) {
            outputDir.mkdir();
        }

        File[] inputFiles = inputDir.listFiles();
        if (inputFiles != null) {
            for (File inputFile : inputFiles) {
                ExamRecord[] records = readInputFile(inputFile.toPath());
                if (records.length > 0) {
                    writeToCSV(records, outputDir, inputFile.getName());
                }
            }
        }
    }

    private static ExamRecord[] readInputFile(Path path) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Chyba při čtení souboru: " + path);
            return new ExamRecord[0];
        }

        List<ExamRecord> resultList = new ArrayList<>();
        for (String line : lines) {
            String[] split = line.split("[:=;]");
            if (split.length == 2) {
                try {
                    resultList.add(new ExamRecord(
                            split[0].trim(),
                            Fraction.parse(split[1].trim())
                    ));
                } catch (NumberFormatException e) {
                    System.out.println("Chyba při převodu zlomku pro: " + line);
                }
            }
        }
        return resultList.toArray(new ExamRecord[0]);
    }

    private static void writeToCSV(ExamRecord[] records, File outputDir, String inputFileName) {
        String outputFileName = inputFileName.substring(0, inputFileName.lastIndexOf(".")) + ".csv";
        File outputFile = new File(outputDir, outputFileName);

        try (FileWriter writer = new FileWriter(outputFile)) {
            for (ExamRecord record : records) {
                writer.append(record.getName())
                        .append(",")
                        .append(record.getFraction().toString())
                        .append("\n");
            }
        } catch (IOException e) {
            System.out.println("Chyba při zápisu do souboru: " + outputFile.getAbsolutePath());
        }
    }
}