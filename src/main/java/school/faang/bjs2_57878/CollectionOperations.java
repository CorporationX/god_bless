package school.faang.bjs2_57878;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionOperations {

    public static Set<List<Integer>> findUniquePairs(Set<Integer> numbers, int target) {
        CollectionOperations v = new CollectionOperations();
        v.validate(numbers, "numbers");

        Set<Integer> seen = new HashSet<>();
        return numbers.stream()
                .filter(n -> {
                    int complement = target - n;
                    return !seen.contains(n) && numbers.contains(complement) && n != complement;
                })
                .peek(seen::add)
                .map(n -> Arrays.asList(Math.min(n, target - n), Math.max(n, target - n)))
                .collect(Collectors.toSet());
    }

    public static List<String> sortCountriesByName(Map<String, String> countries) {
        CollectionOperations v = new CollectionOperations();
        v.validate(countries, "countries");

        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public static List<String> filterAndSortStrings(List<String> strings, char prefix) {
        CollectionOperations v = new CollectionOperations();
        v.validate(strings, "strings");

        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(prefix)))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        CollectionOperations v = new CollectionOperations();
        v.validate(numbers, "numbers");

        return numbers.stream()
                .map(Integer::toBinaryString)
                .collect(Collectors.toList());
    }

    public static List<String> filterByAlphabetAndSort(List<String> strings, String alphabet) {
        CollectionOperations v = new CollectionOperations();
        v.validate(strings, "strings");

        return strings.stream()
                .filter(s -> s.chars().allMatch(c -> alphabet.indexOf(c) >= 0))
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    private <T> void validate(T obj, String name) {
        Objects.requireNonNull(obj, name + " is null");
    }
}
