package ru.maks1979.task_47268;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        TestStreamApi testStreamApi = new TestStreamApi();
        List<Integer> nums = Arrays.asList(1, 3, 5, 7, 10, 12);
        Integer someInt = 13;
        Map<Integer, Integer> uniquePairs = testStreamApi.filterUniquePairs(nums, someInt);
        System.out.println(someInt + ": " + uniquePairs);

        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("France", "Paris");
        countriesAndCapitals.put("Germany", "Berlin");
        List<String> sortedCapitals = testStreamApi.capitalSorting(countriesAndCapitals);
        System.out.println(sortedCapitals);

        List<String> words = Arrays.asList("apple", "banana", "grape", "cherry", "blueberry");
        String symbol = "a";
        List<String> filteredAndSortedWords = testStreamApi.filterAndSort(words, symbol);
        System.out.println(symbol + "': " + filteredAndSortedWords);

        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<String> binaryStrings = testStreamApi.intToString(intList);
        System.out.println(binaryStrings);

        List<String> stringList = Arrays.asList("cat", "bat", "apple", "grape", "cab");
        Set<Character> alphabet = new HashSet<>(Arrays.asList('a', 'b', 'c', 't', 'g', 'r', 'p', 'e', 'l'));
        List<String> filteredSortedStrings = TestStreamApi.filterAndSortStrings(stringList, alphabet);
        System.out.println(filteredSortedStrings);
    }
}

