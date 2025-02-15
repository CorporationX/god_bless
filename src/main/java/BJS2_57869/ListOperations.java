package BJS2_57869;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {
    public static Set<List<Integer>> findPairs(Set<Integer> set, int sum) {
        return set.stream()
                .filter(num -> num != sum - num && set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCitiesByCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> strings, Character c) {
        return strings.stream()
                .filter(str -> str.startsWith(c.toString()))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> transformToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterStringsByAlphabetAndSort(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(str -> str.chars().allMatch(ch -> alphabet.contains(String.valueOf((char) ch))))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
