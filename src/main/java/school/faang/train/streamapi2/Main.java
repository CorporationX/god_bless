package school.faang.train.streamapi2;

import java.util.*;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        final Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        final Map<String, String> countries = Map.of(
                "Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        final List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        final List<Integer> digits = List.of(1, 2, 3, 4);
        final List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        final String alphabet = "abcdefghijklmnopqrstuvwxyz";

        executeAndPrint(() -> Functions.findUniquePairNumber(numbers, 6), "sum");
        executeAndPrint(() -> Functions.sortCountry(countries), "map");
        executeAndPrint(() -> Functions.filterAndSortStrings(fruits, 'a'), "list");
        executeAndPrint(() -> Functions.convertNumberIntoBinary(digits), "list");
        executeAndPrint(() -> Functions.filterStringByAlphabetAndSortByLength(words, alphabet), "list");
    }

    private static <T> void executeAndPrint(Supplier<T> supplier, String paramName) {
        try {
            System.out.printf("%n%s", supplier.get());
        } catch (IllegalArgumentException e) {
            System.out.printf("Error when %s is null: %s%n", paramName, e.getMessage());
        }
    }
}
