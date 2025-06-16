package school.faang.bjs2_80723;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOfOperations {
    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int num) {
        return numbers.stream()
                .filter(number -> number != num - number && numbers.contains(num - number))
                .map(number -> Arrays.asList(number, num - number))
                .peek(Collections::sort)
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitals(Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(List<String> strings, char c) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(c)))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertTo(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(s -> s.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
