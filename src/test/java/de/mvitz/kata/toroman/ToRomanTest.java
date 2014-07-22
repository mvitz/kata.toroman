package de.mvitz.kata.toroman;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ToRomanTest {

    // acceptance test cases taken from wikipedia: http://en.wikipedia.org/wiki/Roman_numerals
    @Test
    @Parameters({
            "1954, MCMLIV",
            "1990, MCMXC",
            "2014, MMXIV",
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
    public void acceptanceTest(int arabicNumber, String expectedRomanNumber) {
        final ToRoman sut = new ToRoman();
        final String result = sut.convert(arabicNumber);
        assertThat(result).isEqualTo(expectedRomanNumber);
    }

}
