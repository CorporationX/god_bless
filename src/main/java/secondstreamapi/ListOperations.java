package secondstreamapi;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {

    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int value) {
        if (numbers == null) {
            return Set.of();
        }

        return numbers.stream()
                .flatMap(num ->
                        numbers.stream()
                                .filter(delta -> delta > num && num + delta == value)
                                .map(delta -> List.of(num, delta))
                )
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countriesAndCapitals) {
        return (countriesAndCapitals == null || countriesAndCapitals.isEmpty())
                ? List.of()
                : countriesAndCapitals.keySet().stream()
                .sorted()
                .map(countriesAndCapitals::get)
                .toList();
    }

    public static List<String> filterAndSort(List<String> strings, char character) {
        return (strings == null || strings.isEmpty())
                ? List.of()
                : strings.stream()
                .filter(string -> string.startsWith(String.valueOf(character)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return (numbers == null || numbers.isEmpty())
                ? List.of()
                : numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByLength(List<String> words, String alphabet) {
        String regex = "[" + alphabet + "]+";

        return words.stream()
                .filter(word -> word.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
