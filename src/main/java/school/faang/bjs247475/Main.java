package school.faang.bjs247475;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(Utilities.findUniquePairsOfNumbers(List.of(5, 5, 4, 6, 5, 5), 10));
        System.out.println(Utilities.getSortedCapitals(
                Map.of("Russia", "Moscow",
                        "USA", "Washington",
                        "Germany", "Berlin")));
        System.out.println(Utilities.filterAndSortByLetter(List.of("apple", "banana", "avocado", "apricot"), 'a'));
        System.out.println(Utilities.decimalsToBinary(List.of(1, 2, 3, 4, 5, 6)));
        System.out.println(Utilities.filterByAlphabet(List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz"));
    }
}
