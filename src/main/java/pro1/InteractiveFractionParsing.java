package pro1;

import java.util.Scanner;

public class InteractiveFractionParsing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Zadej dva zlomky");
        String input = sc.nextLine();

        try{
            Fraction result = Fraction.parse(input);
            System.out.println("Zadal jste zlomek " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Zadal jste neplatný řetězec " + input);
        }
    }
}

