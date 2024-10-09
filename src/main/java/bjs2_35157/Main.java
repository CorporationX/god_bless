package bjs2_35157;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<List<Integer>> pairs = Solution.findPairs(List.of(8, 5, 2, 3, 6, 7, 2, 3, 4), 10);
        List<String> capitals = Solution.getCapitals(
                Map.of("Russia", "Moscow",
                        "Japan", "Tokyo",
                        "Belarus", "Minsk",
                        "Egypt", "Cairo")
        );
        List<String> filterAndSortStrings = Solution.filterAndSortStrings(
                List.of("apple", "banana", "avocado", "apricot"), 'a');
        List<String> binaryStrings = Solution.integerToBinaryString(List.of(1, 2, 3, 4));
        List<String> filterAndSortByAlphabet = Solution.filterAndSortByAlphabet(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopq"
        );

        System.out.println(pairs);
        System.out.println(capitals);
        System.out.println(filterAndSortStrings);
        System.out.println(binaryStrings);
        System.out.println(filterAndSortByAlphabet);
    }
}
