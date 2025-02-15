package school.faang.task_57833;

import java.util.*;
import java.util.stream.Collectors;

public class Operations {
    private static final String REGEX = "[" + "abcdefghijklmnopqrstuvwxyz" + "]+";

    public static Set<List<Integer>> uniquePairs(Set<Integer> set, int sum) {
        return set.stream()
                .filter(num -> num != sum - num && set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .collect(Collectors.toSet());
    }

    public static List<String> getCapitals(Map<String, String> countries) {
        return countries.values().stream()
                .sorted()
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> list, char c) {
        return list.stream()
                .filter(s -> !s.isBlank() && s.charAt(0) == c)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> list) {
        return list.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings) {
        return strings.stream()
                .filter(s -> s.matches(REGEX))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
