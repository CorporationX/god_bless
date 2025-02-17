package school.faang.lets_practice_streamAPI_2.BJS2_58055;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        ListOperations.findPairsWithSum(numbers, 6).forEach(System.out::println);

        Map<String, String> countriesAndCapitals = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin");
        ListOperations.sortingCapitals(countriesAndCapitals).forEach(System.out::println);

        List<String> list = List.of("apple", "banana", "avocado", "apricot");
        ListOperations.filteringAndSortingOfStrings(list, 'a').forEach(System.out::println);

        List<Integer> number = List.of(1, 2, 3, 4);
        ListOperations.convertingNumbersToBinary(number).forEach(System.out::println);

        List<String> words = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        ListOperations.filteringStringsAlphabeticallyAndSortingByLength(words, alphabet).forEach(System.out::println);
    }
}
