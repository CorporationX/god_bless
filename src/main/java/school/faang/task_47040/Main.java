package school.faang.task_47040;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(Operations.getUniquePairs(List.of(1, 2, 3, 4, 5, 6), 7));

        System.out.println(Operations.getCapitals(Map.of("Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin")));

        System.out.println(Operations.filterAndSortingStrings(List.of("apple", "banana", "avocado", "apricot")));

        System.out.println(Operations.convertToBinary(List.of(1, 2, 3, 4)));

        System.out.println(Operations.filterStringsByAlphabet(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz"));
    }
}
