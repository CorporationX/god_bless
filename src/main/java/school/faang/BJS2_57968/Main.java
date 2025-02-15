package school.faang.BJS2_57968;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        System.out.println(StreamApi.uniquePairsOfNumbers(numbers, 6));

        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        System.out.println(StreamApi.sortCountryAndPrintCapital(countries));

        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        System.out.println(StreamApi.filterAndSortedString(fruits, 'a'));

        List<Integer> nums = List.of(1, 2, 3, 4);
        System.out.println(StreamApi.convertToBinary(nums));

        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        System.out.println(StreamApi.filterStringByAlphabetAndSortedByLength(
                strings, "abcdefghijklmnopqrstuvwxyz"));
    }
}
