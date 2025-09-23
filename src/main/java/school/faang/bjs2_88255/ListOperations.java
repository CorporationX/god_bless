package school.faang.bjs2_88255;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {
    public static List<String> findingUniquePairsNumbers(Set<Integer> numbers, int targetNumber) {
        return numbers.stream()
                .flatMap(a -> numbers.stream()
                        .filter(b -> b > a && a + b == targetNumber)
                        .map(b -> "(" + a + ", " + b + ")"))
                .collect(Collectors.toList());
    }

    public static List<String> sortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> strings, char firstChar) {
        return strings.stream()
                .filter(s -> s.charAt(0) == firstChar)
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterByAlphabetAndSort(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.toLowerCase().chars()
                        .allMatch(c -> alphabet.indexOf(c) != -1))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}