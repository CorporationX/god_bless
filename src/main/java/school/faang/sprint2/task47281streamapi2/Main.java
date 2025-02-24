package school.faang.sprint2.task47281streamapi2;

import java.util.*;

import static school.faang.sprint2.task47281streamapi2.Solution.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int sum = 10;
        Set<List<Integer>> pairs = findPairs(numbers, sum);
        System.out.println("Pairs that sum to " + sum + ": " + pairs);

        Map<String, String> countryCapitals = new HashMap<>();
        countryCapitals.put("USA", "Washington");
        countryCapitals.put("Germany", "Berlin");
        countryCapitals.put("India", "New Delhi");
        countryCapitals.put("France", "Paris");
        List<String> capitals = sorted(countryCapitals);
        System.out.println("Sorted capitals: " + capitals);

        List<String> words = Arrays.asList("apple", "banana", "apricot", "grapes", "avocado");
        char targetChar = 'a';
        List<String> sortedWords = sortedString(words, targetChar);
        System.out.println("Words starting with '" + targetChar + "' sorted by length: " + sortedWords);

        List<Integer> numbersForBinary = Arrays.asList(1, 2, 3, 4, 5);
        List<String> binaryStrings = toBinary(numbersForBinary);
        System.out.println("Binary representation: " + binaryStrings);

        List<String> wordsForFiltering = Arrays.asList("apple", "bat", "cat", "dog", "elephant");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> filteredSortedWords = filterAndSorted(wordsForFiltering, alphabet);
        System.out.println("Filtered and sorted words: " + filteredSortedWords);
    }
}

