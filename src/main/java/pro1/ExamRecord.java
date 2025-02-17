package pro1;

import java.nio.file.Path;

public class ExamRecord
{
    private String name;
    private Fraction score;

    public ExamRecord(String name, Fraction score) {
        this.score = score;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Fraction getScore() {
        return score;
    }
}
