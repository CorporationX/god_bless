package school.faang.streamAPI2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<List<Integer>> findPairsEqualToNumber(List<Integer> numbers, int sum) {
        Set<Integer> set = new HashSet<>(numbers);

        return numbers.stream()
                .filter(num -> set.contains(sum - num))
                .map(num -> Arrays.asList(num, sum - num))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> findSortedCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(capital -> capital.getValue())
                .toList();
    }

    public static List<String> sortByCharAndLength(List<String> strings, char ch) {
        return strings.stream()
                .filter(s -> s.charAt(0) == ch)
                .sorted(Comparator.comparingInt(String::length))
                .toList();

    }

    public static List<String> intToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> sortByAlphabet(List<String> strings, String alphabet) {
        return strings.stream()
                .filter(s -> s.matches("[" + alphabet + "]+"))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
