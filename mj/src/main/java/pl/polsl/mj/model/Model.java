package pl.polsl.mj.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Model class, responsible for converting arabic numbers to roman and vice versa.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.1
 */
public class Model {
    private static final List<Integer> ARABIC_VALUES = Arrays.asList(1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000);
    private static final List<String> ROMAN_NUMERALS = Arrays.asList("I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M");

    
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
        int i = ARABIC_VALUES.size() - 1;
        while (arabic > 0) {
            if (ARABIC_VALUES.get(i) <= arabic) {
                roman.append(ROMAN_NUMERALS.get(i));
                arabic -= ARABIC_VALUES.get(i);
            } else {
                i--;
            }
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
        return switch (currentChar) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}


