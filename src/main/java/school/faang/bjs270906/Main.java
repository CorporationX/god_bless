package school.faang.bjs270906;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        ListOperations listOperations = new ListOperations();


        System.out.println(listOperations.findPairs(IntStream.range(1, 6).boxed().collect(Collectors.toSet()), 6));

        Map<String, String> countriesAndCapitals = Map.of("Russia", "Moscow", "USA", "Washington", "Germany", "Berlin");
        System.out.println(listOperations.sortCapitals(countriesAndCapitals));

        List<String> fruits = List.of("apple", "banana", "avocado", "apricot");
        char symbol = 'a';
        System.out.println(listOperations.filterStrings(fruits, symbol));

        System.out.println(listOperations.toBinary(IntStream.range(1, 5).boxed().collect(Collectors.toList())));

        List<String> strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(listOperations.filterAndSortByLength(strings, alphabet));
    }
}
