package school.faang.streamAPI2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(6, 1, 4, 5, 2, 9, 2, 8, 4);
        List<String> strings = List.of("apple", "banana", "ahahaha", "BOO1");
        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(ListOperations.findPairsEqualToNumber(numbers, 12));
        System.out.println(ListOperations.findSortedCapitals(countries));
        System.out.println(ListOperations.sortByCharAndLength(strings, 'a'));
        System.out.println(ListOperations.intToBinary(numbers));
        System.out.println(ListOperations.sortByAlphabet(strings, alphabet));

    }
}
