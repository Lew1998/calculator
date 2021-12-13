import java.util.Scanner;

public class Calculator {
    private static final NumbersConverter numbersConverter = new NumbersConverter();

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String[] example = scanner.nextLine().split(" ");
            Checker checker = new Checker();
            boolean isRoman = checker.checkRomanOrArabic(example);
            calculate(isRoman, Integer.parseInt(example[0]), example[1], Integer.parseInt(example[2]));
        }
    }

    private static void calculate(boolean isRoman, int numberOne, String operator, int numberTwo) {
        if (operator.equals("+")) printResult(isRoman, numberOne + numberTwo);
        else if (operator.equals("-")) printResult(isRoman, numberOne - numberTwo);
        else if (operator.equals("*")) printResult(isRoman, numberOne * numberTwo);
        else if (operator.equals("/")) printResult(isRoman, numberOne / numberTwo);
        else System.out.println("Некорректный оператор");
    }

    private static void printResult(boolean isRoman, int result) {
        if (isRoman) {
            System.out.println(numbersConverter.transformArabicToRoman(result));
        } else System.out.println(result);
    }
}
