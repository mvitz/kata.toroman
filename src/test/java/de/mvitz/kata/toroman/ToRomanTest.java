package de.mvitz.kata.toroman;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ToRomanTest {

    // acceptance test cases taken from wikipedia: http://en.wikipedia.org/wiki/Roman_numerals
    @Test
    @Parameters({
            "1954, MCMLIV",
            "1990, MCMXC",
            "2014, MMXIV"
    })
    public void acceptanceTest(int arabicNumber, String expectedRomanNumber) {
        final ToRoman sut = new ToRoman();
        final String result = sut.convert(arabicNumber);
        assertThat(result).isEqualTo(expectedRomanNumber);
    }

    @Test
    @Parameters({
            "1, I",
            "4, IV",
            "5, V",
            "9, IX",
            "10, X",
            "40, XL",
            "50, L",
            "90, XC",
            "400, CD",
            "500, D",
            "900, CM",
            "1000, M"
    })
    public void shouldTranslateSingleFactor(int factor, String expectedRomanDigit) {
        final ToRoman sut = new ToRoman();
        final Collection<String> romanDigits = sut.translate(Arrays.asList(factor));
        assertThat(romanDigits).containsExactly(expectedRomanDigit);
    }

    @Test
    public void shouldTranslateMultipleFactors() {
        final ToRoman sut = new ToRoman();
        final Collection<String> romanDigits = sut.translate(Arrays.asList(1, 5));
        assertThat(romanDigits).containsExactly("I", "V");
    }

    @Test
    public void shouldCompileRomanDigits() {
        final ToRoman sut = new ToRoman();
        final String romanNumber = sut.compile(Arrays.asList("X", "IV"));
        assertThat(romanNumber).isEqualTo("XIV");
    }

}
