package school.faang.collections_stream_api_optional.bjs2_87880;

import lombok.NonNull;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    private static final Comparator<String> stringLengthComparator = Comparator.comparingInt(String::length);

    private static final Predicate<String> isNotNullOrEmpty = string -> string != null && !string.isBlank();
    private static final Predicate<Integer> isNotNullOrGreaterZero = number -> number != null && number >= 0;

    public static void main(String[] args) {
        System.out.println(findPairsWithSum(Set.of(1, 2, 3, 4, 5, 6), 6));

        Map<String, String> capitals = Map.of(
                "Russia", "Moscow",      // ключ → значение
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println(listCapitalsSortedByCountry(capitals));

        System.out.println(filterAndSortStrings(List.of("apple",
                        "banana",
                        "avocado",
                        "apricot"),
                'a'));

        System.out.println(toBinaryString(List.of(1, 2, 3, 4)));

        System.out.println(filterAlphabeticAndSortByLength(List.of("apple",
                        "banana",
                        "cherry",
                        "date",
                        "fig",
                        "grape"),
                "abcdefghijklmnopqrstuvwxyz"));
    }

    private static Set<Set<Integer>> findPairsWithSum(@NonNull Set<Integer> set, int targetNumber) {

        if (!isNotNullOrGreaterZero.test(targetNumber)) {
            throw new IllegalArgumentException("Не верное значение: " + targetNumber);
        }

        return set.stream()
                .filter(Objects::nonNull)
                .map(number -> set.stream()
                        .filter(Objects::nonNull)
                        .sorted()
                        .filter(number2 -> number > number2 && number2 + number == targetNumber)
                        .map(number2 -> Set.of(number, number2))
                        .collect(Collectors.toSet()))
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    private static List<String> listCapitalsSortedByCountry(@NonNull Map<String, String> countriesAndCities) {
        return countriesAndCities.entrySet()
                .stream()
                .filter(item -> isNotNullOrEmpty.test(item.getKey())
                        || isNotNullOrEmpty.test(item.getValue()))
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .toList();
    }

    private static List<String> filterAndSortStrings(@NonNull List<String> listStrings, char symbolLineStart) {

        String prefix = String.valueOf(symbolLineStart);
        return listStrings.stream()
                .filter(isNotNullOrEmpty)
                .filter(string -> string.startsWith(prefix))
                .sorted(stringLengthComparator)
                .toList();
    }

    private static List<String> toBinaryString(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(isNotNullOrGreaterZero)
                .map(Integer::toBinaryString)
                .toList();
    }

    private static List<String> filterAlphabeticAndSortByLength(@NonNull List<String> listStrings, String alphabet) {
        return listStrings.stream()
                .filter(isNotNullOrEmpty)
                .filter(string -> IntStream.range(0, string.length())
                        .allMatch(item -> alphabet.indexOf(string.charAt(item)) >= 0))
                .sorted(stringLengthComparator)
                .toList();
    }
}