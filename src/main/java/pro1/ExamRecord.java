package pro1;

import java.nio.file.Path;

public class ExamRecord
{
    private String name;
    private Fraction fraction;

    public ExamRecord(String name, Fraction fraction) {
        this.fraction = fraction;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Fraction getFraction() {
        return fraction;
    }
}
