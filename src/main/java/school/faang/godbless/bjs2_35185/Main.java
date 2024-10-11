package school.faang.godbless.bjs2_35185;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(0, 2, 10, 12, 0, 5);
        System.out.println("Pairs of numbers that sum up to 12: " + StreamOperationsManager.getPairsThatSumUpToTarget(numbers, 12));

        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println("Capitals of sorted counties: " + StreamOperationsManager.getCapitalsOfSortedCountries(countries));

        List<String> words = List.of("apple", "banana", "avocado", "apricot", "32dsa");
        System.out.println("Words that start with a sorted by length: " +
                StreamOperationsManager.getFilteredByStartWithSymbolAndSortedByLength(words, 'a'));

        System.out.println("Binary representation of numbers: " + StreamOperationsManager.getNumbersAsBinary(numbers));

        System.out.println("Words filtered by alphabet abcdefghijklmnopqrstuvwxyz and sorted by length: "
                + StreamOperationsManager.getFilteredByAlphabetAndSortedByLength(words, "abcdefghijklmnopqrstuvwxyz"));
    }
}
