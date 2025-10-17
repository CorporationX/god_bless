package bjs289299;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Calculate {

    public static Set<List<Integer>> findUniquePairs(Set<Integer> set, int sum) {
        return set.stream()
                .filter(num -> num != sum - num && set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> findCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue).toList();
    }

    public static List<String> getSortedStringsStartedWith(List<String> strs, char c) {
        return strs.stream()
                .filter(str -> str.charAt(0) == c)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> transformToBinaryAsString(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAccordingToAlphSortedBzLength(List<String> strs, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strs.stream()
                .filter(str -> str.matches(regex))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
