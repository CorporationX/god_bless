package school.faang.sprint2.task_47341;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.findPairs(List.of(1, 2, 3, 4, 5, 6), 7));
        System.out.println(Solution.sortCapitals(Map.of(
                "Russia", "Moscow", "USA", "Washington", "Germany", "Berlin")));
        System.out.println(Solution.findStringsStartsWithChar(List.of("apple", "banana", "avocado", "apricot"), 'a'));
        System.out.println(Solution.convertNumsToBinaryFormat(List.of(1, 2, 3, 4)));
        System.out.println(Solution.findStringsConsistingOf(
                List.of("apple", "banana", "cherry", "date", "fig", "grape"), "abcdefghijklmnopqrstuvwxyz"));
    }
}
