package school.faang.stream_api_2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Task 1
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int target = 6;
        System.out.println("Unique pairs summing to " + target + ": " +
                UniquePairsFinder.findUniquePairs(numbers, target));
        // Task 2
        Map<String, String> countryCapitals = new HashMap<>();
        countryCapitals.put("Russia", "Moscow");
        countryCapitals.put("USA", "Washington");
        countryCapitals.put("Germany", "Berlin");
        System.out.printf("Sorted capitals: %s%n", CountryCapitalSorter.sortCountriesAndGetCapitals(countryCapitals));

        // Task 3
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        char symbol = 'a';
        System.out.println("Filtered and sorted strings starting with '" + symbol
                + "': " + StringFilterAndSorter.filterAndSortStrings(strings, symbol));

        // Task 4
        List<Integer> numsToConvert = Arrays.asList(1, 2, 3, 4);
        System.out.printf("Binary conversion: %s%n", BinaryConverter.convertToBinary(numsToConvert));

        // Task 5
        List<String> stringsToFilter = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.printf("Filtered strings by alphabet and sorted: %s%n",
                AlphabeticalStringFilterAndSorter.filterByAlphabetAndSortByLength(stringsToFilter, alphabet));
    }
}