package school.faang.BJS2_57950;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> firstNumbers = Set.of(1, 2, 3, 4, 5, 6);
        int target = 6;
        Map<Integer, Integer> uniquePairs =
                CollectionOperations.uniquePairsOfNumbers(firstNumbers, target);
        System.out.println("1. " + uniquePairs);

        Map<String, String> countries = Map.of("Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin");
        System.out.printf("2. %s\n", CollectionOperations.sortCountries(countries));

        List<String> secondList = List.of("apple", "banana", "avocado", "apricot");
        char ch = 'a';
        System.out.printf("3. %s\n", CollectionOperations.filterAndSortOfStrings(secondList, ch));

        List<Integer> secondNumbers = List.of(1, 2, 3, 4);
        System.out.printf("4. %s\n", CollectionOperations.convertToBinaryFormat(secondNumbers));

        List<String> thirdList = List.of("ap-ple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.printf("5. %s\n",
                CollectionOperations.alphabetFilteringAndSorting(thirdList, alphabet));
    }
}