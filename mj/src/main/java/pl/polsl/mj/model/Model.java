package pl.polsl.mj.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Model class, responsible for converting arabic numbers to roman and vice versa.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.4
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
     * List of conversion data.
     */
    private final List<ConversionData> history;

    /**
     * Enum for roman numerals.
     */
    private enum RomanNumeral {
        /**
         * Roman numeral M - 1000 value.
         */
        M(1000),
        /**
         * Roman numeral CM - 900 value.
         */
        CM(900),
        /**
         * Roman numeral D - 500 value.
         */
        D(500),
        /**
         * Roman numeral CD - 400 value.
         */
        CD(400),
        /**
         * Roman numeral C - 100 value.
         */
        C(100),
        /**
         * Roman numeral XC - 90 value.
         */
        XC(90),
        /**
         * Roman numeral L - 50 value.
         */
        L(50),
        /**
         * Roman numeral XL - 40 value.
         */
        XL(40),
        /**
         * Roman numeral X - 10 value.
         */
        X(10),
        /**
         * Roman numeral IX - 9 value.
         */
        IX(9),
        /**
         * Roman numeral V - 5 value.
         */
        V(5),
        /**
         * Roman numeral IV - 4 value.
         */
        IV(4),
        /**
         * Roman numeral I - 1 value.
         */
        I(1);

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
     * Constructor for Model class.
     * Initializes the history list.
     */
    public Model() {
        this.history = new ArrayList<>();
    }

    /**
     * Getter for history.
     *
     * @return history
     */
    public List<ConversionData> getHistory() {
        return history;
    }

    /**
     * Method for converting arabic numbers to roman.
     *
     * @param arabic arabic number to be converted
     * @return roman numeral
     * @throws ModelException when arabic number is invalid
     */
    public String arabicToRoman(int arabic) throws ModelException {
        if (!validateArabic("" + arabic)) {
            throw new ModelException("Invalid arabic number");
        }
        StringBuilder roman = new StringBuilder();
        String tmpArabic = "" + arabic;
        int i = 0;
        for (int value : ARABIC_VALUES) {
            while (arabic >= value) {
                arabic -= value;
                roman.append(ROMAN_NUMERALS.get(i));
            }
            i++;
        }
        history.add(new ConversionData("Arabic to Roman", tmpArabic, roman.toString(), getDate()));
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
        if (!validateRoman(roman)) {
            throw new ModelException("Invalid roman numeral");
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

        history.add(new ConversionData("Roman to Arabic", roman, "" + arabic, getDate()));
        return arabic;
    }

    /**
     * Method for getting current date.
     *
     * @return current date
     */
    private Date getDate() {
        return new Date();
    }

    /**
     * Method for getting arabic value of a roman numeral.
     *
     * @param currentChar current character
     * @return arabic value of a roman numeral
     */
    int getArabicValue(char currentChar) {
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
        if (roman == null || roman.trim().isEmpty()) return false;
        return roman.matches("^(M{0,3})(C(?:D|M)|D?C{0,3})(X(?:L|C)|L?X{0,3})(I(?:V|X)|V?I{0,3})$");
    }

    /**
     * Method use for arabic number validation.
     *
     * @param input arabic number to be validated
     * @return true if arabic number is valid, false otherwise
     */
    public boolean validateArabic(String input) {
        int arabic;
        try {
            arabic = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return arabic >= 1 && arabic <= 3999;
    }
}
