package school.faang.BJS2_57860;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        int targetSum = 6;

        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        char symbol = 'a';
        List<Integer> numbersToBinary = List.of(1, 2, 3, 4);

        List<String> input = List.of("apple", "banana", "cherry", "date", "fig", "grape", "kiwi", "mango");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(ListOperations.findPairs(numbers, targetSum)); // [[2, 4], [1, 5]]
        System.out.println(ListOperations.sortCities(countries)); // [Berlin, Moscow, Washington]
        System.out.println(
                ListOperations.filterByStartCharAndSortByLength(strings, symbol) //[apple, avocado, apricot]
        );
        System.out.println(ListOperations.convertToBinary(numbersToBinary)); //["1", "10", "11", "100"]
        System.out.println(
                ListOperations.filterAndSortStringsByAlphabet(input, alphabet) // [fig,date,apple,grape,banana,cherry]
        );

    }
}
