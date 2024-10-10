package school.faangSprint2.t9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public static List<List<Integer>> findUniquePairs(List<Integer> numbers, int target) {
        return numbers.stream()
                .flatMap(i -> numbers.stream()
                        .filter(j -> numbers.indexOf(j) > numbers.indexOf(i))
                        .filter(j -> i + j == target)
                        .map(j -> Arrays.asList(i, j)))
                .collect(Collectors.toList());
    }

    public static List<String> sortAndGetCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> strings, char startChar) {
        return strings.stream()
                .filter(s -> s.charAt(0) == startChar)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(n -> Integer.toBinaryString(n))
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.indexOf(c) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}