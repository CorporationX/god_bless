package school.faang.streamapi_2;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ListOperations {

    public record Pair<F, S>(F first, S second) {
    }

    public static List<Pair<Integer, Integer>> findUniquePairs(Set<Integer> numbers, int sum) {
        Set<Integer> checked = new HashSet<>();
        return numbers.stream()
                .filter(num -> {
                    int pair = sum - num;
                    boolean found = checked.contains(pair);
                    checked.add(num);
                    return found;
                })
                .map(num -> new Pair<>(num, sum - num))
                .toList();
    }

    public static List<String> sortCountriesByAlphabetAndGetCapitals(Map<String, String> countryCapitals) {
        return countryCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSort(List<String> strings, char startChar) {
        return strings.stream()
                .filter(str -> !str.isEmpty() && str.startsWith(String.valueOf(startChar)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> filterAndSortByAlphabet(List<String> strings, String alphabet) {
        Set<Character> allowedUniqueChars = alphabet.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        return strings.stream()
                .filter(str -> str.chars().allMatch(v -> allowedUniqueChars.contains((char) v)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
