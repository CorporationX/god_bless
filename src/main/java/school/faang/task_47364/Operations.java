package school.faang.task_47364;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Operations {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static Set<List<Integer>> findPairsToSum(List<Integer> numbers, int sum) {
        Set<List<Integer>> pairs;
        Set<Integer> set = new HashSet<>(numbers);

        pairs = numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        return pairs;
    }

    public static List<String> getSortedCapitals(Map<String, String> capitalByCountry) {
        return capitalByCountry.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> sortedStrings(List<String> strings, char ch) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(ch)))
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static List<String> conversionToBinaryFormat(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortedStrings(List<String> strings) {
        String regex = String.format("[%s]+", ALPHABET);
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
