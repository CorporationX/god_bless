package school.faang.bjs247317;

import java.util.*;

import static school.faang.bjs247317.Processor.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = 7;
        Set<List<Integer>> uniquePairs = uniqueSum(numbers, sum);
        System.out.println("Unique pairs with sum " + sum + ": " + uniquePairs);

        Map<String, String> countries = new HashMap<>();
        countries.put("USA", "Washington");
        countries.put("Canada", "Ottawa");
        countries.put("UK", "London");
        List<String> capitals = sortedCapitals(countries);
        System.out.println("Sorted capitals: " + capitals);

        List<String> strings = Arrays.asList("banana", "apricot", "apple", "blueberry", "avocado");
        char letter = 'a';
        List<String> sortedStrings = sortStartingWithChar(strings, letter);
        System.out.println("Strings starting with '" + letter + "': " + sortedStrings);

        List<Integer> binaryNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<String> binaryStrings = numbersToBinary(binaryNumbers);
        System.out.println("Binary representations: " + binaryStrings);

        List<String> alphabetStrings = Arrays.asList("apple", "banana", "apricot", "blueberry", "avocado");
        String alphabet = "abcdfghijklmnopqrstuvwxyz";
        List<String> sortedAlphabetStrings = sortOfAlphabet(alphabetStrings, alphabet);
        System.out.println("Strings sorted by alphabet: " + sortedAlphabetStrings);
    }
}

