package pl.polsl.mj.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;

class ModelTest {

    @Disabled("Conversion need to be implemented")
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

    @Disabled("Conversion need to be implemented")
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
}

