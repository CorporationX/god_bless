package school.faang;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Operations {
    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int sum) {
        validateSet(numbers);
        return numbers.stream()
                .filter(num -> numbers.contains(sum - num) && num * 2 != sum)
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countries) {
        validateMap(countries);
        return countries.values().stream()
                .sorted()
                .toList();
    }

    public static List<String> filterAndSort(List<String> strings, char start) {
        validateList(strings);
        return strings.stream()
                .filter(str -> str.charAt(0) == start)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        validateList(numbers);
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        validateList(strings);
        validateAlphabet(alphabet);
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(str -> str.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    private static void validateAlphabet(String alphabet) {
        if (alphabet == null) {
            throw new IllegalArgumentException("Alphabet can't be null.");
        }
    }

    private static <T> void validateList(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("The list can't be null");
        }
    }

    private static <U, V> void validateMap(Map<U, V> map) {
        if (map == null) {
            throw new IllegalArgumentException("The map can't be null");
        }
        for (var entry : map.entrySet()) {
            if (entry.getKey() == null) {
                throw new IllegalArgumentException("The key in map can't be null");
            } else if (entry.getValue() == null) {
                throw new IllegalArgumentException("The value in map can't be null");
            }
        }
    }

    private static <T> void validateSet(Set<T> set) {
        if (set == null) {
            throw new IllegalArgumentException("The set can't be null");
        }
        for (var entry : set) {
            if (entry == null) {
                throw new IllegalArgumentException("Value in set can't be null");
            }
        }
    }
}
