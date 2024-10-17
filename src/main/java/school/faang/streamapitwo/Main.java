package school.faang.streamapitwo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int targetSum = 7;
        List<Pair> pairs = UniquePairsFinder.findUniquePairs(numbers, targetSum);
        System.out.println("Unique pairs: " + pairs);

        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("Russia", "Moscow");
        countryCapitalMap.put("USA", "Washington");
        countryCapitalMap.put("Germany", "Berlin");
        List<String> sortedCapitals = CountryCapitalSorter.getSortedCapitals(countryCapitalMap);
        System.out.println("Sorted capitals: " + sortedCapitals);

        List<String> fruits = Arrays.asList("apple", "banana", "avocado", "apricot");
        List<String> filteredFruits = StringFilterSorter.filterAndSortStrings(fruits, 'a');
        System.out.println("Filtered and sorted fruits: " + filteredFruits);

        List<Integer> numsToConvert = Arrays.asList(1, 2, 3, 4);
        List<String> binaryStrings = NumberToBinaryConverter.convertToBinary(numsToConvert);
        System.out.println("Binary conversion: " + binaryStrings);

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> filteredWords = AlphabetStringFilter.filterByAlphabetAndSortByLength(words, alphabet);
        System.out.println("Filtered and sorted by alphabet: " + filteredWords);
    }
}

