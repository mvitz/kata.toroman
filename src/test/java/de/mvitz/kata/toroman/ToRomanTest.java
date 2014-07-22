package de.mvitz.kata.toroman;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.Collection;

import static junitparams.JUnitParamsRunner.$;
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

    @Test
    @Parameters(method = "factors")
    public void shouldFindFactors(String description, int arabicNumber, Integer[] expectedFactors) {
        final ToRoman sut = new ToRoman();
        final Collection<Integer> factors = sut.findFactors(arabicNumber);
        assertThat(factors).describedAs(description).containsExactly(expectedFactors);
    }

    private Object[] factors() {
        return $(
                $("single factor",           1000, new Integer[] { 1000       }),
                $("consecutive factors",     1900, new Integer[] { 1000,  900 }),
                $("same factor",             2000, new Integer[] { 1000, 1000 }),
                $("non-consecutive factors", 1400, new Integer[] { 1000,  400 })
        );
    }

    @Test
    @Parameters(method = "factor")
    public void shouldFindFactor(int arabicNumber, Collection<Integer> factors, int expectedFactor) {
        final ToRoman sut = new ToRoman();
        final int factor = sut.findFactor(arabicNumber, factors);
        assertThat(factor).isEqualTo(expectedFactor);
    }

    private Object[] factor() {
        return $(
                $(11, Arrays.asList(10, 5), 10),
                $( 9, Arrays.asList(10, 5),  5)
        );
    }

}
