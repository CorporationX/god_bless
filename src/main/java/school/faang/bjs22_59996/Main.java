package school.faang.bjs22_59996;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> set = Set.of(1, 2, 3, 4, 5, 6);
        Map<String, String> capitals = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println(ListOperation.findUniquePairsOfNumbers(set, 6));
        System.out.println(ListOperation.sortedCapital(capitals));
        System.out.println(ListOperation.sortingLines(List.of("apple", "banana", "avocado", "apricot"), 'a'));
        System.out.println(ListOperation.convertBinaryFormat((List.of(1, 2, 3, 4))));
        System.out.println(ListOperation.filterLines(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"), "abcdefghijklmnopqrstuvwxyz"));
    }
}
