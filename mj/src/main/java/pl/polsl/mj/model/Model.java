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
    private static final List<Integer> ARABIC_VALUES = new ArrayList<>();
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
        return "";  // Implement this method
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
        return 0;  // Implement this method
    }
}


