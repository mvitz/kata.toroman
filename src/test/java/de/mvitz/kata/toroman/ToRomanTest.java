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
            "2014, MMXIV"
    })
    public void acceptanceTest(int arabicNumber, String expectedRomanNumber) {
        final ToRoman sut = new ToRoman();
        final String result = sut.convert(arabicNumber);
        assertThat(result).isEqualTo(expectedRomanNumber);
    }

}
