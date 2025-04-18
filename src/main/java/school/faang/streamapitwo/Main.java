package school.faang.streamapitwo;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Test 1: Unique Pairs ===");
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        int target = 6;
        Set<Pair<Integer, Integer>> pairs = TrainingStreamApi.findUniquePairs(numbers, target);
        System.out.print("Pairs: ");
        for (Pair<Integer, Integer> p : pairs) {
            System.out.printf("(%d, %d) ", p.getFirst(), p.getSecond());
        }
        System.out.println("\n");

        System.out.println("=== Test 2: Sorted Capitals ===");
        Map<String, String> countryMap = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        List<String> capitals = TrainingStreamApi.getSortedCapitals(countryMap);
        System.out.printf("Capitals: %s%n%n", capitals);

        System.out.println("=== Test 3: Filter and Sort by First Char ===");
        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        char firstChar = 'a';
        List<String> filtered = TrainingStreamApi.filterAndSortByFirstChar(fruits, firstChar);
        System.out.printf("Result: %s%n%n", filtered);

        System.out.println("=== Test 4: Convert to Binary ===");
        List<Integer> numsList = List.of(1, 2, 3, 4);
        List<String> binaries = TrainingStreamApi.toBinaryList(numsList);
        System.out.printf("Binaries: %s%n%n", binaries);

        System.out.println("=== Test 5: Filter by Alphabet and Sort by Length ===");
        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> alphaSorted = TrainingStreamApi.filterByAlphabetAndSort(words, alphabet);
        System.out.printf("Result: %s%n", alphaSorted);
    }
}
