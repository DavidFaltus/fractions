package pro1;
import java.io.File;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args)
    {

        File inputDir=new File("C:/data/input");
        File[] inputFiles= inputDir.listFiles();
        for(File inputFile : inputFiles)
        {
            System.out.println("Reading "+inputFile);
            ExamRecord[] records = readInputFile(inputFile.toPath());
        }
    }
    public static ExamRecord[] readInputFile(Path path)
    {

        return new ExamRecord[0];
    }
}