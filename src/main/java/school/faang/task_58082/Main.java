package school.faang.task_58082;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        System.out.println(ListOperations.findPair(numbers, 6));

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        System.out.println(ListOperations.getSortedCapitals(countries));

        List<String> fruits = new ArrayList<>(Arrays.asList("apple", "banana", "avocado", "apricot"));
        System.out.println(ListOperations.sortFilteredRows(fruits, 'a'));

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        System.out.println(ListOperations.convertToBinary(nums));

        List<String> moreFruits = new ArrayList<>(Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape"));
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(ListOperations.filterRowsByAlphabet(moreFruits, alphabet));
    }
}
