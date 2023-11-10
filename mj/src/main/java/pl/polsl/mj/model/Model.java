/**
 * Model package - responsible for converting arabic numbers to roman and vice versa.
 */
package pl.polsl.mj.model;

import java.util.Arrays;
import java.util.List;

/**
 * Model class, responsible for converting arabic numbers to roman and vice versa.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.1
 */
public class Model {
    /**
     * List of arabic values.
     */
    private static final List<Integer> ARABIC_VALUES = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
    /**
     * List of roman numerals.
     */
    private static final List<String> ROMAN_NUMERALS = Arrays.asList("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");

    /**
     * Enum for roman numerals.
     */
    private enum RomanNumeral {
        /**
         * Roman numerals.
         */
        M(1000), CM(900), D(500), CD(400), C(100), XC(90),
        L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

        /**
         * Arabic value of a roman numeral.
         */
        private final int value;

        /**
         * Constructor for RomanNumeral enum.
         *
         * @param value arabic value of a roman numeral
         */
        RomanNumeral(int value) {
            this.value = value;
        }

        /**
         * Getter for arabic value of a roman numeral.
         *
         * @return arabic value of a roman numeral
         */
        public int getValue() {
            return value;
        }
    }

    /**
     * Method for converting arabic numbers to roman.
     *
     * @param arabic arabic number to be converted
     * @return roman numeral
     * @throws ModelException when arabic number is invalid
     */
    public String arabicToRoman(int arabic) throws ModelException {
        if (arabic < 1 || arabic > 3999) {
            throw new ModelException("Invalid arabic number. It must be between 1 and 3999.");
        }

        StringBuilder roman = new StringBuilder();
        int i = 0;
        for (int value : ARABIC_VALUES) {
            while (arabic >= value) {
                arabic -= value;
                roman.append(ROMAN_NUMERALS.get(i));
            }
            i++;
        }
        return roman.toString();
    }

    /**
     * Method for converting roman numerals to arabic.
     *
     * @param roman roman numeral to be converted
     * @return arabic number
     * @throws ModelException when roman numeral is invalid
     */
    public int romanToArabic(String roman) throws ModelException {
        if (roman == null || roman.isEmpty()) {
            throw new ModelException("Invalid roman numeral. It must not be null or empty.");
        }

        int arabic = 0;

        for (int i = 0; i < roman.length(); i++) {
            char currentChar = roman.charAt(i);
            int currentValue = getArabicValue(currentChar);
            if (i + 1 < roman.length()) {
                char nextChar = roman.charAt(i + 1);
                int nextValue = getArabicValue(nextChar);
                if (currentValue < nextValue) {
                    arabic += nextValue - currentValue;
                    i++;
                } else {
                    arabic += currentValue;
                }
            } else {
                arabic += currentValue;
            }
        }

        return arabic;
    }

    /**
     * Method for getting arabic value of a roman numeral.
     *
     * @param currentChar current character
     * @return arabic value of a roman numeral
     */
    private int getArabicValue(char currentChar) {
        RomanNumeral numeral = RomanNumeral.valueOf(String.valueOf(currentChar));
        return numeral.getValue();
    }

    /**
     * Method use for roman numeral validation.
     *
     * @param roman roman numeral to be validated
     * @return true if roman numeral is valid, false otherwise
     */
    public boolean validateRoman(String roman) {
        return roman.matches("^(?=[MDCLXVI])M*(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
    }
}

