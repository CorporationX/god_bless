package school.faang.bjs247395;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.bjs247395.StreamApi2.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = 8;
        findUniqPairs(numbers, sum);

        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        char letter = 'a';
        filterAndSorting(strings, letter);


        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");

        getSortedCapitals(countries);

        List<String> binaryStrings = convertToBinary(numbers);

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        filterAndSortByLength(strings, alphabet);
    }
}
