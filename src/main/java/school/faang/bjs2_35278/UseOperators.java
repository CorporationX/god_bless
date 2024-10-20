package school.faang.bjs2_35278;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static school.faang.bjs2_35278.Operators.convertToBinary;
import static school.faang.bjs2_35278.Operators.countriesCapitals;
import static school.faang.bjs2_35278.Operators.filteredAndSorted;
import static school.faang.bjs2_35278.Operators.sortedAndFiltered;
import static school.faang.bjs2_35278.Operators.uniqPairs;


public class UseOperators {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> filteredAndSortedWords = filteredAndSorted(words, alphabet);

        System.out.println(filteredAndSortedWords);

        List<Integer> integerList = Arrays.asList(1, 2, 3, 4); // Renamed from 'numbers' to 'integerList'
        List<String> binaryNumbers = convertToBinary(integerList);

        System.out.println(binaryNumbers);

        List<String> listOfNames = Arrays.asList("apple", "banana", "avocado", "apricot");
        char startChar = 'a';

        List<String> result = sortedAndFiltered(listOfNames, startChar);

        System.out.println(result);

        Map<String, String> countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("Russia", "Moscow");
        countryCapitalMap.put("USA", "Washington");
        countryCapitalMap.put("Germany", "Berlin");

        List<String> capitals = countriesCapitals(countryCapitalMap);
        System.out.println(capitals);

        int[] numberArray = {1, 2, 3, 4, 5, 6}; // Renamed from 'numbers' to 'numberArray'
        int target = 7;

        List<int[]> pairs = uniqPairs(numberArray, target);

        System.out.println("Unique pairs with sum " + target + ":");
        for (int[] pair : pairs) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }

    }
}