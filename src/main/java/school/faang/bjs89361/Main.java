package school.faang.bjs89361;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println(StreamOperations.findUniqPairsOfNumber(Set.of(1, 2, 3, 4, 5, 6), 6));

        Set<String> sortedCountries = StreamOperations.sortCountryNamesWithCapitals(
            Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin")
        );
        System.out.println(sortedCountries);

        List<String> filteredAndSortedStrings =
            StreamOperations.filterAndSortStringValues(List.of("apple", "banana", "avocado", "apricot"), "a");
        System.out.println(filteredAndSortedStrings);

        System.out.println(StreamOperations.convertNumberToBinar(List.of(1, 2, 3, 4)));

        List<String> filteredAndSortedStringAlphabet =
            StreamOperations.filterOnlyLettersAlphabetAndSortByLength(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"), "abcdefghijklmnopqrstuvwxyz");
        System.out.println(filteredAndSortedStringAlphabet);
    }
}
