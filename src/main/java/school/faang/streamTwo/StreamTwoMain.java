package school.faang.streamTwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamTwoMain {
    public static void main(String[] args) {

        // Unique pairs
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Map<Integer, Integer> pairs = Operations.findPairs(numbers, 7);

        System.out.println("Вход: " + numbers);
        System.out.println("Выход: " + Operations.findPairs(numbers, 7));

        // Sort capitals

        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("Russia", "Moscow");
        countryCapitalMap.put("USA", "Washington");
        countryCapitalMap.put("Germany", "Berlin");

        List<String> sortedCapitals = Operations.sortCapitals(countryCapitalMap);
        System.out.println(sortedCapitals);

        // Sort strings

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        char startChar = 'a';
        List<String> result = Operations.filterAndSort(strings, startChar);
        System.out.println(result);

        // Map to binary

        List<Integer> numbersList = Arrays.asList(1, 2, 3, 4);
        List<String> binaryStrings = Operations.toBinary(numbersList);
        System.out.println(binaryStrings);

        // Alphabet sort

        List<String> alphaStrings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> sortResult = Operations.filterAndSort(alphaStrings, alphabet);
        System.out.println(sortResult);
    }
}
