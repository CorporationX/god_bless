package school.faang.stream2;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        int target = 6;
        System.out.println("Pairs summing to " + target + ": " +
                StreamFunctions.findPairs(numbers, target));

        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println("Sorted capitals: " +
                StreamFunctions.sortedCapitals(countries));

        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        char filterChar = 'a';
        System.out.println("Filtered & sorted: " +
                StreamFunctions.filterAndSortByLength(fruits, filterChar));

        List<Integer> nums = List.of(1, 2, 3, 4);
        System.out.println("Binary strings: " +
                StreamFunctions.convertToBinary(nums));

        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Filtered by alphabet & sorted: " +
                StreamFunctions.filterByAlphabetAndSort(words, alphabet));
    }
}
