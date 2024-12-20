package school.faang.sprint2.task_9;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 0, 4, 5, 6, 7);
        int target = 7;

        Set<List<Integer>> result = ListOperations.getUniquePairs(numbers, target);
        System.out.println(result);

        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("USA", "Washington");
        countriesAndCapitals.put("Germany", "Berlin");

        List<String> capitals = ListOperations.sortCapitals(countriesAndCapitals);
        System.out.println(capitals);

        List<String> fruits = Arrays.asList("apple", "banana", "avocado", "apricot");
        String symbol = "a";
        List<String> filteredFruits = ListOperations.filterFruits(fruits, symbol);

        System.out.println(filteredFruits);

        List<Integer> numbersToBinary = Arrays.asList(1, 2, 3, 4);
        List<String> binary = ListOperations.toBinary(numbersToBinary);

        System.out.println(binary);

        List<String> wordsToSort = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        List<String> sortedWords = ListOperations.sortWords(wordsToSort, alphabet);

        System.out.println(sortedWords);
    }
}
