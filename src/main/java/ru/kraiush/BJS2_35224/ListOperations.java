package ru.kraiush.BJS2_35224;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class ListOperations {

    public static List<int[]> findUniqueSums(List<Integer> nums, int target) {
        Set<Integer> checkedNums = new HashSet<>();
        return nums.stream().flatMap(num -> {
            int complement = target - num;
            if (checkedNums.contains(complement)) {
                return Stream.of(new int[]{complement, num});
            } else {
                checkedNums.add(num);
                return Stream.empty();
            }
        })
                .toList();
    }

    public static List<String> getCapitalsOrderedByAlphabet(Map<String, String> countriesCapitals) {
        return countriesCapitals.entrySet().stream()
                .map(country -> country.getValue())
                .sorted()
                .toList();
    }

    public static List<String> filterStringsStartingWithCharAndSortByLength(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> mapToBinaryFromDecimal(List<Integer> nums) {
        return nums.stream()
                .map(num -> Integer.toBinaryString(num))
                .toList();
    }

    public static List<String> filterStringsByAlphabetAndLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.indexOf(c) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
