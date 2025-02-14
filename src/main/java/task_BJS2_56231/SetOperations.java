package task_BJS2_56231;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class SetOperations {

    public static Set<List<Integer>> findUniquePairs(Set<Integer> numbers, int targetNumber) {
        return numbers.stream()
                .filter(number -> number != targetNumber - number && numbers.contains(targetNumber - number))
                .map(number -> Arrays.asList(number, targetNumber - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortString(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .sorted()
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortStringByLength(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(string -> string.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
