package pro1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FractionParsingTest {
    @Test
    void test01()
    {
        assertEquals(
                "3/17",
                Fraction.parse("3/17").toString()

        );
    }

    @Test
    void test02()
    {
        assertEquals(
                "35/116",
                Fraction.parse("3/58 + 6/24").toString()

        );
    }

    @Test
    void test03()
    {
        assertEquals(
                "73/100",
                Fraction.parse("2% +71%").toString()

        );
    }

    @Test
    void test04()
    {
        assertEquals(
                "3/5",
                Fraction.parse("60%").toString()

        );
    }

    @Test
    void test05()
    {
        assertEquals(
                "11/25",
                Fraction.parse("31% + 12% + 1%").toString()

        );
    }

    @Test
    void test06()
    {
        assertEquals(
                "5/7",
                Fraction.parse("25/35").toString()

        );
    }

    @Test
    void test07()
    {
        assertEquals(
                "3/4",
                Fraction.parse("25% + 1/2").toString()

        );
    }

    @Test
    void test08()
    {
        assertEquals(
                "–1/2",
                Fraction.parse("–5/10").toString()
        );
    }

    @Test
    void test09()
    {
        assertEquals(
                "3/17",
                Fraction.parse("-3/-17").toString()
        );
    }

    @Test
    void test10()
    {
        assertEquals(
                "-3/11",
                Fraction.parse("3/-11").toString()
        );
    }
}
