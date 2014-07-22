package de.mvitz.kata.toroman;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public final class ToRoman {

    public String convert(int arabicNumber) {
        final Collection<Integer> factors = findFactors(arabicNumber);
        final Collection<String> romanDigits = translate(factors);
        return compile(romanDigits);
    }

    private Collection<Integer> findFactors(int arabicNumber) {
        throw new UnsupportedOperationException("Not implemented!");
    }

    Collection<String> translate(Collection<Integer> factors) {
        final Map<Integer, String> arabicToRoman = new HashMap<>();
        arabicToRoman.put(1, "I");
        arabicToRoman.put(4, "IV");
        arabicToRoman.put(5, "V");
        arabicToRoman.put(9, "IX");
        arabicToRoman.put(10, "X");
        arabicToRoman.put(40, "XL");
        arabicToRoman.put(50, "L");
        arabicToRoman.put(90, "XC");
        arabicToRoman.put(400, "CD");
        arabicToRoman.put(500, "D");
        arabicToRoman.put(900, "CM");
        arabicToRoman.put(1000, "M");

        return factors.stream().map(arabicToRoman::get).collect(Collectors.toList());
    }

    String compile(Collection<String> romanDigits) {
        return String.join("", romanDigits);
    }

}
