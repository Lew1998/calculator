public class Checker {
    private final NumbersConverter numbersConverter = new NumbersConverter();

    public boolean checkRomanOrArabic(String[] example) {
        if (example.length != 3) {
            System.err.println("Некорректный ввод");
        }
        try {
            Integer.parseInt(example[0]);
            Integer.parseInt(example[2]);
        } catch (NumberFormatException ex) {
            try {
                example[0] = String.valueOf(numbersConverter.transformRomanToArabic(example[0]));
                example[2] = String.valueOf(numbersConverter.transformRomanToArabic(example[2]));
                return true;
            } catch (Exception x) {
                System.err.println("Некорректный ввод римских цифр");
            }
        }
        return false;
    }
}
