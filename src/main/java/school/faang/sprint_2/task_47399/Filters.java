package school.faang.sprint_2.task_47399;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Filters {
    public static Set<List<Integer>> uniquePairsOfNumbers(List<Integer> numbers, int targetNumber) {
        return numbers.stream()
                .filter(n -> numbers.contains(targetNumber - n))
                .map(n -> Arrays.asList(n, targetNumber - n))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> countryAndCapital(Map<String, String> countryCapital) {
        return countryCapital.values().stream()
                .sorted()
                .toList();
    }

    public static List<String> sortingStrings(List<String> strings, char targetChar) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(targetChar)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> binaryFormat(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> sortAlphabetically(List<String> strings, String abc) {
        String regex = "[" + abc + "]+";
        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}
