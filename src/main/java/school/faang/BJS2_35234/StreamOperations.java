package school.faang.BJS2_35234;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamOperations {
    public static Set<List<Integer>> findUniquePairs(List<Integer> numbers, int target) {
        Set<List<Integer>> pairs = new HashSet<>();
        Set<Integer> viewedNumbers = new HashSet<>(numbers);

        pairs = numbers.stream()
                .filter(number -> viewedNumbers.contains(target - number))
                .map(number -> Arrays.asList(number, target - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());

        return pairs;
    }

    public static List<String> getCapitalCities(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterList(List<String> strings, char startWith) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startWith)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertingToBinaryFormat(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSort(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}
