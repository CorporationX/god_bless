package school.faang.task_47232;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<List<Integer>> findPairs(List<Integer> numbers, int sum) {
        Set<Integer> values = new HashSet<>(numbers.size());
        values.addAll(numbers);
        return numbers.stream()
                .filter(x -> values.contains(sum - x))
                .map(x -> Arrays.asList(x, sum - x))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortingCountries(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> sortStrings(List<String> strings, char start) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(start)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinaryNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
