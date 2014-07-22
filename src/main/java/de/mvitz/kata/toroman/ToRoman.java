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
        final Collection<Integer> possibleFactors = Arrays.asList(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        final Collection<Integer> factors = new ArrayList<>();
        while (arabicNumber > 0) {
            final int factor = findFactor(arabicNumber, possibleFactors);
            factors.add(factor);
            arabicNumber -= factor;
        }
        return factors;
    }

    int findFactor(int arabicNumber, Collection<Integer> factors) {
        return factors.stream().filter(f -> f <= arabicNumber).findFirst().get();
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
