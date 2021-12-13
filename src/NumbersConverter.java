import java.util.List;

public class NumbersConverter {
    private final List<RomanNumbers> romanNumbers = RomanNumbers.getReverseValues();

    public String transformArabicToRoman(int number) {

        StringBuilder res = new StringBuilder();
        for (int i = 0; i < romanNumbers.size(); i++) {
            while (number >= romanNumbers.get(i).value()) {
                number -= romanNumbers.get(i).value();
                res.append(romanNumbers.get(i).name());
            }
        }
        return res.toString();
    }

    public int transformRomanToArabic(String roman_number) {
        String[] roman_in_arr = roman_number.split("");
        int result = 0;
        for (int i = 0; i < roman_in_arr.length; i++) {
            int currentValue = RomanNumbers.valueOf(roman_in_arr[i]).value();
            if (i + 1 >= roman_in_arr.length) {
                result += currentValue;
                break;
            }
            int NextValue = RomanNumbers.valueOf(roman_in_arr[i + 1]).value();
            if (currentValue < NextValue) {
                result += NextValue - currentValue;
                i++;
            } else {
                result += currentValue;
            }
        }
        return result;
    }
}
