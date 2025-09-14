package school.faang.bjs2_87972;

import java.util.*;
import java.util.stream.Collectors;

public class ManagerOperations {
    public static Set<List<Integer>> findPairDistinctNumbers(Set<Integer> numbers, int targetNumber) {
        return numbers.stream()
                .filter(num -> num != targetNumber - num && numbers.contains(targetNumber - num))
                .map(num -> Arrays.asList(num, targetNumber - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortedCapitals(Map<String, String> countries) {
        return countries.values().stream()
                .sorted()
                .toList();
    }

    public static List<String> filteredStings(List<String> strings, char letter) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(letter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertingNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
