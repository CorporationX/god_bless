package bjs289299;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {

        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        int targetSum = 7;
        Set<List<Integer>> pairs = Calculate.findUniquePairs(numbers, targetSum);
        System.out.println("Unique pairs with sum " + targetSum + ": " + pairs);

        Map<String, String> countries = new TreeMap<>();
        countries.put("USA", "Washington");
        countries.put("France", "Paris");
        countries.put("Germany", "Berlin");
        List<String> capitals = Calculate.findCapitals(countries);
        System.out.println("Capitals sorted by country: " + capitals);

        List<String> words = List.of("apple", "apricot", "banana", "avocado", "aardvark");
        char startChar = 'a';
        List<String> sortedWords = Calculate.getSortedStringsStartedWith(words, startChar);
        System.out.println("Words starting with '" + startChar + "' sorted by length: " + sortedWords);

        List<Integer> nums = List.of(3, 5, 10, 15);
        List<String> binaries = Calculate.transformToBinaryAsString(nums);
        System.out.println("Binary representations: " + binaries);

        List<String> letters = List.of("abc", "aab", "abcd", "bca", "xyz", "cba");
        String alphabet = "abc";
        List<String> filtered = Calculate.filterAccordingToAlphSortedBzLength(letters, alphabet);
        System.out.println("Filtered & sorted strings: " + filtered);
    }
}
