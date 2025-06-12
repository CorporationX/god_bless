package school.faang.module1.bjs2_80690;

import java.util.*;
import java.util.stream.Collectors;

public class Operations {

    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int target) {
        return numbers.stream()
                .flatMap(a -> numbers.stream()
                        .filter(b -> a < b && a + b == target)
                        .map(b -> Arrays.asList(a, b)))
                .collect(Collectors.toSet());
    }

    public static List<String> getSortedCapitals(Map<String, String> countriesAndTheirCapitals) {
        return countriesAndTheirCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortByLength(List<String> strings, char startsWithCharacter) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startsWithCharacter)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterByAlphabetAndSort(List<String> strings, String alphabet) {

        Set<Character> allowedChars = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(s -> s.chars()
                        .mapToObj(c -> (char) c)
                        .allMatch(allowedChars::contains))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }
}