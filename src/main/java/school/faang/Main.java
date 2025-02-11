package school.faang;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6);
        System.out.println(Operations.findPairs(set, 6));
        Map<String, String> capitals = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println(Operations.getSortedCapitals(capitals));
        System.out.println(Operations.filterAndSort(List.of("apple", "banana", "avocado", "apricot"), 'a'));
        System.out.println(Operations.convertToBinary(List.of(1, 2, 3, 4)));
        System.out.println(Operations.filterAndSortByLength(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"), "abcdefghijklmnopqrstuvwxyz"));

    }
}
