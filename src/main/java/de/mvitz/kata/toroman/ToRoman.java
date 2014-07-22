package de.mvitz.kata.toroman;

import java.util.Collection;

public final class ToRoman {

    public String convert(int arabicNumber) {
        final Collection<Integer> factors = findFactors(arabicNumber);
        final Collection<String> romanDigits = translate(factors);
        return compile(romanDigits);
    }

    private Collection<Integer> findFactors(int arabicNumber) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    private Collection<String> translate(Collection<Integer> factors) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    private String compile(Collection<String> romanDigits) {
        throw new UnsupportedOperationException("Not implemented!");
    }

}
