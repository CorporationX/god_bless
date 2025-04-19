package school.faang.bjs2_72288;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        try {
            StreamOperations operations = new StreamOperations();

            Set<Integer> nums = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
            int targetSum = 7;
            Set<IntegerPair> resultPairs = operations.getIntegerPairsMatchingSum(nums, targetSum);
            System.out.println("Пары с суммой " + targetSum + ": " + resultPairs);

            Map<String, String> countries = new HashMap<>();
            countries.put("Russia", "Moscow");
            countries.put("USA", "Washington");
            countries.put("Germany", "Berlin");
            countries.put(null, "Unknown");
            countries.put("Italy", null);
            List<String> capitals = operations.getCapitals(countries);
            System.out.println("Capitals by alphabetical order of countries: " + capitals);

            List<String> words = Arrays.asList("apple", "banana", "apricot", "cherry", "Avocado", null);
            List<String> filteredByPrefix = operations.filterByPrefixAndSortStrings(words, 'a');
            System.out.println("Words with 'a' sorted by length: " + filteredByPrefix);

            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, null, 8);
            List<String> binaryList = operations.toBinary(numbers);
            System.out.println("Numbers in binary format: " + binaryList);

            List<String> fruits = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "piña");
            String alphabet = "abcdefghijklmnopqrstuvwxyz";
            List<String> filteredFruits = operations.filterByAlphabetAndSortByLength(fruits, alphabet);
            System.out.println("Fruit, with Latin letters only, by length: " + filteredFruits);

            operations.toBinary(null);
        } catch (ParamsInStreamOperationsIsNullException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
