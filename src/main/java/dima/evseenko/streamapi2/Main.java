package dima.evseenko.streamapi2;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(StreamOperations.findUniquePairs(List.of(1, 2, 3, 4, 5, 6), 7));
        System.out.println(StreamOperations.sortCapitals(Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin")));
        System.out.println(StreamOperations.filterAndSorting(List.of("apple", "banana", "avocado", "apricot"), 'a'));
        System.out.println(StreamOperations.numbersToBinaries(List.of(1, 2, 3, 4)));
        System.out.println(StreamOperations.filterByAlphabetAndSort(List.of("apple", "banana", "cherry", "date", "fig", "grape"), "abcdefghijklmnopqrstuvwxyz"));
    }
}
