package school.faang.bjs247395;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
public class StreamApi2 {

    public static Set<List<Integer>> findUniqPairs(List<Integer> numbers, int sum) {
        if (numbers == null || numbers.isEmpty()) {
            log.warn("findUniqPairs: The list of integers is null or empty. Please provide a non-empty list.");
            throw new IllegalArgumentException("findUniqPairs: 'numbers' must not be null or empty.");
        }

        Set<Integer> set = new HashSet<>(numbers);
        Set<List<Integer>> pairs = numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
        log.info("findUniqPairs: Found unique pairs for sum {}: {}", sum, pairs);
        return pairs;
    }

    public static List<String> getSortedCapitals(Map<String, String> countries) {
        if (countries == null || countries.isEmpty()) {
            log.warn("getSortedCapitals: The country map is null or empty. Please provide a non-empty map.");
            throw new IllegalArgumentException("getSortedCapitals: 'countries' must not be null or empty.");
        }

        List<String> result = countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
        log.info("getSortedCapitals: Capitals sorted by their country names: {}", result);
        return result;
    }

    public static List<String> filterAndSorting(List<String> strings, char letter) {
        if (strings == null || strings.isEmpty()) {
            log.warn("filterAndSorting: The string list is null or empty. Please provide a non-empty list.");
            throw new IllegalArgumentException("filterAndSorting: 'strings' must not be null or empty.");
        }

        List<String> filtered = strings.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        log.info("filterAndSorting: Filtered and sorted strings that start with '{}': {}", letter, filtered);
        return filtered;
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            log.warn("convertToBinary: The list of integers is null or empty. Please provide a non-empty list.");
            throw new IllegalArgumentException("convertToBinary: 'numbers' must not be null or empty.");
        }

        List<String> result = numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
        log.info("convertToBinary: Numbers converted to binary: {}", result);
        return result;
    }

    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        if (strings == null || strings.isEmpty()) {
            log.warn("filterAndSortByLength: The string list is null or empty. Please provide a non-empty list.");
            throw new IllegalArgumentException("filterAndSortByLength: 'strings' must not be null or empty.");
        }

        if (alphabet == null || alphabet.isEmpty()) {
            log.warn("filterAndSortByLength: The alphabet string is null or empty. Please provide a non-empty string.");
            throw new IllegalArgumentException("filterAndSortByLength: 'alphabet' must not be null or empty.");
        }

        String regex = "[" + alphabet + "]+";
        List<String> result = strings.stream()
                .filter(str -> str.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
        log.info("filterAndSortByLength: Strings that match the alphabet '{}' and sorted by length: {}",
                alphabet, result);
        return result;
    }
}
