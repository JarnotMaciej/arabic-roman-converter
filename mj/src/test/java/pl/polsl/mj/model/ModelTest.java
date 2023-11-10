package pl.polsl.mj.model;

import org.junit.jupiter.api.Test;
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
     * Test of validate method, of class Model for arabic numbers. Valid input is expected.
     */
    @Test
    void testValidateArabicValidInput() {
        Model model = new Model();

        assertTrue(model.validateArabic("1"));
        assertTrue(model.validateArabic("4"));
        assertTrue(model.validateArabic("9"));
        assertTrue(model.validateArabic("12"));
        assertTrue(model.validateArabic("3999"));
        assertTrue(model.validateArabic("1000"));
        assertTrue(model.validateArabic("900"));
        assertTrue(model.validateArabic("500"));
        assertTrue(model.validateArabic("50"));
        assertTrue(model.validateArabic("40"));
    }

    /**
     * Test of validate method, of class Model for arabic numbers. Invalid input is expected.
     */
    @Test
    void testValidateArabicInvalidInput() {
        Model model = new Model();

        assertFalse(model.validateArabic("0"));
        assertFalse(model.validateArabic("-10"));
        assertFalse(model.validateArabic("4000"));
        assertFalse(model.validateArabic("invalid"));
        assertFalse(model.validateArabic(""));
        assertFalse(model.validateArabic("   "));
    }

    /**
     * Test of validate method, of class Model for roman numerals. Invalid input is expected.
     */
    @ParameterizedTest
    @CsvSource({
            "IIII",
            "XXXX",
            "CCCC",
            "MMMM",
            "VV",
            "LL",
            "DD",
            "IL",
            "IC",
            "ID",
            "IM",
            "XD",
            "XM",
            "LC",
            "LD",
            "LM",
            "DM",
            "invalid",
            "QWERTY",
    })
    void testValidateRomanInvalidInput(String roman) {
        Model model = new Model();
        assertFalse(model.validateRoman(roman));
    }

    /**
     * Testing empty string, null and whitespace string.
     */
    @Test
    void testValidateRomanEmptyString() {
        Model model = new Model();
        assertFalse(model.validateRoman(""));
        assertFalse(model.validateRoman("   "));
        assertFalse(model.validateRoman(null));
    }

    /**
     * Test of validate method, of class Model for roman numerals. Valid input is expected.
     */
    @ParameterizedTest
    @CsvSource({
            "I",
            "IV",
            "IX",
            "XII",
            "XIV",
            "XX",
            "XL",
            "L",
            "XC",
            "C",
            "CD",
            "D",
            "CM",
            "M",
            "MMMCMXCIX"
    })
    void testValidateRomanValidInput(String roman) {
        Model model = new Model();
        assertTrue(model.validateRoman(roman));
    }

    /**
     * Test of getArabicValue method, of class Model for valid roman numerals.
     */
    @Test
    void testGetArabicValueForValidRomanNumerals() {
        Model model = new Model();

        assertEquals(1, model.getArabicValue('I'));
        assertEquals(5, model.getArabicValue('V'));
        assertEquals(10, model.getArabicValue('X'));
        assertEquals(50, model.getArabicValue('L'));
        assertEquals(100, model.getArabicValue('C'));
        assertEquals(500, model.getArabicValue('D'));
        assertEquals(1000, model.getArabicValue('M'));
    }

    /**
     * Test of getArabicValue method, of class Model for invalid roman numerals.
     */
    @Test
    void testGetArabicValueForInvalidRomanNumeral() {
        Model model = new Model();
        assertThrows(IllegalArgumentException.class, () -> model.getArabicValue('Z'));
    }
}

