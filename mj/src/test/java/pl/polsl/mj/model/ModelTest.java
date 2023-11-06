package pl.polsl.mj.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

/**
 * Test class created for testing Model class.
 *
 * @author mj300741@student.polsl.pl
 * @version 1.1
 */
class ModelTest {

    /**
     * Test of arabicToRoman method, of class Model.
     * @param arabic Arabic number to be converted
     * @param expectedRoman Expected roman numeral
     * @throws ModelException when arabic number is invalid
     */
    @ParameterizedTest
    @CsvSource({
            "1, I",
            "4, IV",
            "9, IX",
            "12, XII",
            "14, XIV",
            "20, XX",
            "40, XL",
            "50, L",
            "90, XC",
            "100, C",
            "400, CD",
            "500, D",
            "900, CM",
            "1000, M",
            "3999, MMMCMXCIX"
    })
    void testArabicToRoman(int arabic, String expectedRoman) throws ModelException {
        Model model = new Model();
        assertEquals(expectedRoman, model.arabicToRoman(arabic));
    }

    /**
     * Test of romanToArabic method, of class Model.
     * @param roman Roman numeral to be converted
     * @param expectedArabic Expected arabic number
     * @throws ModelException when roman numeral is invalid
     */
    @ParameterizedTest
    @CsvSource({
            "I, 1",
            "IV, 4",
            "IX, 9",
            "XII, 12",
            "XIV, 14",
            "XX, 20",
            "XL, 40",
            "L, 50",
            "XC, 90",
            "C, 100",
            "CD, 400",
            "D, 500",
            "CM, 900",
            "M, 1000",
            "MMMCMXCIX, 3999"
    })
    void testRomanToArabic(String roman, int expectedArabic) throws ModelException {
        Model model = new Model();
        assertEquals(expectedArabic, model.romanToArabic(roman));
    }

    /**
     * Test of arabicToRoman method, of class Model.
     * @param input Arabic number to be converted
     * @param expectedMessage Expected exception message
     */
    @Disabled // TODO: fix border cases in romanToArabic
    @ParameterizedTest
    @CsvSource({
            "0, Invalid arabic number. It must be between 1 and 3999.",
            "4000, Invalid arabic number. It must be between 1 and 3999.",
            "-1, Invalid arabic number. It must be between 1 and 3999.",
            "MMMM, Invalid roman number. It must be between I and MMMCMXCIX.",
            "MMMMCMXCIX, Invalid roman number. It must be between I and MMMCMXCIX.",
            "MMMMCMXCIXI, Invalid roman number. It must be between I and MMMCMXCIX.",
            "MMMMCMXCIXII, Invalid roman number. It must be between I and MMMCMXCIX.",
            "MMMMCMXCIXIV, Invalid roman number. It must be between I and MMMCMXCIX.",
            "MMMMCMXCIXV, Invalid roman number. It must be between I and MMMCMXCIX."
    })
    void testOutOfRange(int input, String expectedMessage) {
        Model model = new Model();
        ModelException exception = assertThrows(ModelException.class, () -> model.arabicToRoman(input));
        assertEquals(expectedMessage, exception.getMessage());
    }


    /**
     * Test of romanToArabic method, of class Model.
     * @param input Roman numeral to be converted
     * @param expectedMessage Expected exception message
     */
    @Disabled // TODO: create roman number validation
    @ParameterizedTest
    @CsvSource({
            "IIII, Invalid roman number. It must be between I and MMMCMXCIX.",
            "XXXX, Invalid roman number. It must be between I and MMMCMXCIX.",
            "IIX, Invalid roman number. It must be between I and MMMCMXCIX.",
            "VV, Invalid roman number. It must be between I and MMMCMXCIX.",
            "IL, Invalid roman number. It must be between I and MMMCMXCIX.",
            "IC, Invalid roman number. It must be between I and MMMCMXCIX.",
            "VX, Invalid roman number. It must be between I and MMMCMXCIX.",
            "VL, Invalid roman number. It must be between I and MMMCMXCIX.",
            "XD, Invalid roman number. It must be between I and MMMCMXCIX.",
            "XM, Invalid roman number. It must be between I and MMMCMXCIX."
    })
    void testInvalidRoman(String input, String expectedMessage) {
        Model model = new Model();
        ModelException exception = assertThrows(ModelException.class, () -> model.romanToArabic(input));
        assertEquals(expectedMessage, exception.getMessage());
    }
}

