package school.faang.task_60258;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<List<Integer>> findUniquePairs(Set<Integer> numbers, int sum) {
        return numbers.stream()
                .filter(num -> num != sum - num && numbers.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountriesAndGetCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .parallel()
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortStrings(List<String> strings, char character) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(character)))
                .sorted(Comparator.comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterByAlphabetAndSortByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}