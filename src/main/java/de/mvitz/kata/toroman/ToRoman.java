package de.mvitz.kata.toroman;

import java.util.*;
import java.util.stream.Collectors;

public final class ToRoman {

    public String convert(int arabicNumber) {
        final Collection<Integer> factors = findFactors(arabicNumber);
        final Collection<String> romanDigits = translate(factors);
        return compile(romanDigits);
    }

    Collection<Integer> findFactors(int arabicNumber) {
        final Collection<Integer> factors = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        final int factor = findFactor(arabicNumber, factors);
        return Arrays.asList(factor);
    }

    private int findFactor(int arabicNumber, Collection<Integer> factors) {
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
