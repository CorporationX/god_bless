package school.faang.streamapi2;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        int target = 6;
        System.out.println("Pairs: " + Operations.findPairs(numbers, target));

        Map<String, String> countries = Map.of(
                "USA", "Washington",
                "France", "Paris",
                "Japan", "Tokyo",
                "Spain", "Madrid"
        );
        System.out.println("Capitals by countries: " + Operations.getSortedCapitals(countries));

        List<String> words = List.of("apple", "banana", "cherry", "apricot", "blueberry");
        System.out.println("Words started with " + target + ": " + Operations.filteredAndSorted(words, 'a'));

        List<Integer> intNumbers = List.of(1, 2, 3, 4);
        System.out.println("Binary format: " + Operations.toBinaryString(intNumbers));

        List<String> moreWords = List.of("apple", "banana", "cherry", "date", "fig", "grape", "abc123");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Sorted" + Operations.sortedAndFiltered(moreWords, alphabet));
    }
}
