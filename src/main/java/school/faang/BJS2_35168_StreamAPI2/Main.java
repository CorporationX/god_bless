package school.faang.BJS2_35168_StreamAPI2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int requiredSum = 10;
        Set<List<Integer>> pairs = ListOperations.findPairsWithSum(numbers, requiredSum);
        System.out.println("Pairs with sum " + requiredSum + ": " + pairs);

        Map<String, String> capitalsByCountries = new HashMap<>();
        capitalsByCountries.put("Russia", "Moscow");
        capitalsByCountries.put("USA", "Washington");
        capitalsByCountries.put("Germany", "Berlin");
        capitalsByCountries.put("France", "Paris");
        List<String> capitalsOfSortedCountries = ListOperations.sortAndGetCapitals(capitalsByCountries);
        System.out.println("Capitals of sorted countries: " + capitalsOfSortedCountries);

        List<String> words = Arrays.asList("apple", "banana", "avocado", "apricot");
        char filterChar = 'a';
        List<String> filteredAndSortedWords = ListOperations.filterAndSort(words, filterChar);
        System.out.printf("Words starting with symbol '%s': %s\n", filterChar, filteredAndSortedWords);

        numbers = Arrays.asList(1, 2, 3, 4);
        List<String> binaryStrings = ListOperations.convertToBinary(numbers);
        System.out.println("Numbers converted to their binary representation: " + binaryStrings);

        List<String> input = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefgklopqrst";
        List<String> filteredWords = ListOperations.filterAndSort(input, alphabet);
        System.out.printf("Words consisting only of alphabetic characters (%s): %s\n", alphabet, filteredWords);
    }
}
