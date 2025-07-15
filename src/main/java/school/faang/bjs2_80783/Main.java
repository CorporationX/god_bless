package school.faang.bjs2_80783;

import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        Set<String> strings = Set.of("apple", "banana", "cherry", "date", "fig", "grape");
        Map<String, String> countryMap = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        System.out.println(CollectionProcessor.findPairs(numbers, 10));
        System.out.println(CollectionProcessor.findCapitalAndSorted(countryMap));
        System.out.println(CollectionProcessor.filterForStartCharAndSortStrings(strings, 'a'));
        System.out.println(numbers);
        System.out.println(CollectionProcessor.decimalToBinary(numbers));
        System.out.println(CollectionProcessor.filterForAlphabetAndSortStrings(strings, "abcdefghijklmnopqrstuvwxyz"));
    }
}
