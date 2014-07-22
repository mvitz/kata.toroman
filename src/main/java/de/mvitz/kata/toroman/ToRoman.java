package de.mvitz.kata.toroman;

import java.util.*;
import java.util.stream.Collectors;

public final class ToRoman {

    private final Map<Integer, String> map = new HashMap<>();

    public ToRoman() {
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");
    }

    public String convert(int arabicNumber) {
        final Collection<Integer> factors = findFactors(arabicNumber);
        final Collection<String> romanDigits = translate(factors);
        return compile(romanDigits);
    }

    Collection<Integer> findFactors(int arabicNumber) {
        final Collection<Integer> possibleFactors = map.keySet().stream().sorted(Comparator.<Integer>reverseOrder()).collect(Collectors.toList());

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
        return factors.stream().map(map::get).collect(Collectors.toList());
    }

    String compile(Collection<String> romanDigits) {
        return String.join("", romanDigits);
    }

}
