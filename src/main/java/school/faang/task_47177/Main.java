package school.faang.task_47177;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int targetSum = 7;
        Set<List<Integer>> pairs = StreamOperations.collectPair(numbers, targetSum);
        System.out.println("Pairs with sum " + targetSum + ": " + pairs);

        Map<String, String> countryCapital = new HashMap<>();
        countryCapital.put("USA", "Washington");
        countryCapital.put("Russia", "Moscow");
        countryCapital.put("Germany", "Berlin");
        List<String> sortedCapitals = StreamOperations.getSortedCapitals(countryCapital);
        System.out.println("Sorted capitals: " + sortedCapitals);

        List<String> strings = Arrays.asList("apple", "banana", "apricot", "avocado");
        char letter = 'a';
        List<String> filteredAndSorted = StreamOperations.filterAndSort(strings, letter);
        System.out.println("Strings starting with '" + letter + "': " + filteredAndSorted);

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> binaries = StreamOperations.convertToBinary(integers);
        System.out.println("Binary representations: " + binaries);

        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> filteredByRegexAndSorted = new StreamOperations().filterAndSortByLength(words, alphabet);
        System.out.println("Filtered and sorted by regex: " + filteredByRegexAndSorted);
    }
}
