package school.faang.BJS2_57950;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectionOperations {
    public static Map<Integer, Integer> uniquePairsOfNumbers(Set<Integer> numbers, int target) {
        return numbers.stream()
                .filter(num1 -> {
                    int num2 = target - num1;
                    return numbers.contains(num2) && num1 < num2;
                })
                .collect(Collectors.toMap(num -> num, num -> target - num));
    }

    public static List<String> sortCountries(@NonNull Map<String, String> countries) {
        return countries.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> filterAndSortOfStrings(@NonNull List<String> strings,
                                                      char symbol) {
        return strings.stream()
                .filter(s -> s.charAt(0) == symbol)
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static List<String> convertToBinaryFormat(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .map(num -> Integer.toString(num, 2))
                .toList();
    }

    public static List<String> alphabetFilteringAndSorting(@NonNull List<String> strings,
                                                           @NonNull String alphabet) {
        String regex = "[" + alphabet + "]+";
        return strings.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparing(String::length))
                .toList();
    }
}