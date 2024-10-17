package school.faang.StreamAPI2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1.");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int targetNumber = 7;
        System.out.println(ListOperations.UniquePairs(numbers, targetNumber));

        System.out.println("Task 2.");
        Map<String, String> countryCapital = new HashMap<>();
        countryCapital.put("Russia", "Moscow");
        countryCapital.put("USA", "Washington");
        countryCapital.put("Germany", "Berlin");
        System.out.println(ListOperations.capitals(countryCapital));

        System.out.println("Task 3.");
        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        char a = 'a';
        System.out.println(ListOperations.filterSort(strings, a));

        System.out.println("Task 4.");
        numbers = Arrays.asList(1, 2, 3, 4);
        System.out.println(ListOperations.toBinary(numbers));

        System.out.println("Task 4.");
        strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String letters = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(ListOperations.containSort(strings, letters));
    }
}
