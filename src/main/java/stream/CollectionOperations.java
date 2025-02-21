package stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionOperations {

    public static Set<List<Integer>> findPairs(Set<Integer> numbers, int sum) {
        Objects.requireNonNull(numbers, "Set cannot be null.");

        return numbers.stream()
                .flatMap(number -> {
                    int complement = sum - number;
                    if (number < complement && numbers.contains(complement)) {
                        return Stream.of(List.of(number, complement));
                    }
                    return Stream.empty();
                })
                .collect(Collectors.toSet());
    }

    public static List<String> sortCapitals(Map<String, String> countriesAndCapitals) {
        Objects.requireNonNull(countriesAndCapitals, "Map cannot be null.");

        return countriesAndCapitals.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    public static List<String> sortStringsStartingWith(List<String> strings, char character) {
        Objects.requireNonNull(strings, "List cannot be null.");

        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(character)))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> convertToBinary(List<Integer> numbers) {
        Objects.requireNonNull(numbers, "List cannot be null.");
        return numbers.stream()
                .map(Integer::toBinaryString)
                .toList();
    }

    public static List<String> sortStrings(List<String> strings, String alphabet) {
        Objects.requireNonNull(strings, "List cannot be null.");
        Objects.requireNonNull(alphabet, "Alphabet string cannot be null.");

        String regex = "[" + alphabet + "]+";

        return strings.stream()
                .filter(string -> string.matches(regex))
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }
}
