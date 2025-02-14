package task_BJS2_60240;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    private static final Set<Integer> NUMBERS = Set.of(1, 2, 3, 4, 5, 6);
    private static final Map<String, String> COUNTRIES = Map.of(
            "Russia", "Moscow",
            "USA", "Washington",
            "Germany", "Berlin");
    private static final List<String> WORDS = List.of("apple", "banana", "avocado", "apricot");
    private static final char SYMBOL = 'a';
    private static final List<Integer> ANOTHER_NUMBERS = List.of(1, 2, 3, 4);
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
        System.out.println(SetOperations.findUniquePairs(NUMBERS, 6));
        System.out.println(SetOperations.sortCapitals(COUNTRIES));
        System.out.println(SetOperations.filterAndSortString(WORDS, SYMBOL));
        System.out.println(SetOperations.convertToBinary(ANOTHER_NUMBERS));
        System.out.println(SetOperations.filterAndSortStringByLength(WORDS, ALPHABET));

    }
}
