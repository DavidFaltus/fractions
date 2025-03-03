package pro1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args)
    {
        File inputDir=new File("C:/data/input");
        File outputDir=new File("C:/data/output");

        File[] inputFiles= inputDir.listFiles();
        for(File inputFile : inputFiles)
        {
            System.out.println("Reading "+inputFile);
            ExamRecord[] records = readInputFile(inputFile.toPath());
            System.out.println("První človek v souboru: "+records[0].getName());
        }
    }

    private static ExamRecord[] readInputFile(Path path) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException e) {
            return new ExamRecord[0];
        }
        List<ExamRecord> resultList = new ArrayList<>();
        for(String line : lines)
        {
            String[] split= line.split("[:=;]");
            resultList.add(new ExamRecord(
                    split[0],
                    Fraction.parse(split[1])
            ));
        }
        return resultList.toArray(new ExamRecord[0]);
    }

    private static void exportToCsv(List<String> lines, String outputFilePath) throws IOException {
        try (FileWriter fw = new FileWriter(outputFilePath)){
            for (String line : lines) {
                try {
                    Fraction fraction = Fraction.parse(line);
                    fw.append(fraction.toString());
                    fw.append("\n");
                } catch (IllegalArgumentException e){
                    fw.append("Neplatný řetězec"+line);
                    fw.append("\n");
                }
            }
        }
    }
}