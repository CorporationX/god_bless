package school.faang.sprint_2.bjs2_35194;

import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class Main {
    public static void main(String[] args) {
        StreamOperations streamOperations = new StreamOperations();

        int targetSum = 7;
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<Integer> numbers = asList(1, 2, 3, 4, 5, 6, 9, 145);
        List<String> fruits = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );

        streamOperations.findPairs(numbers, targetSum).forEach(System.out::println);
        System.out.println("---".repeat(20));
        System.out.println();

        streamOperations.getSortedCapitals(countries).forEach(System.out::println);
        System.out.println("---".repeat(20));
        System.out.println();

        streamOperations.filterAndSort(fruits, 'a').forEach(System.out::println);
        System.out.println("---".repeat(20));
        System.out.println();

        streamOperations.decimalToBinary(numbers).forEach(System.out::println);
        System.out.println("---".repeat(20));
        System.out.println();

        streamOperations.filterByAlphabetSortByLength(fruits, alphabet).forEach(System.out::println);
        System.out.println("---".repeat(20));
        System.out.println();
    }
}

