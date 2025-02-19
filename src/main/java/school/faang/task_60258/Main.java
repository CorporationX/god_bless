package school.faang.task_60258;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static school.faang.task_60258.ListOperations.convertToBinary;
import static school.faang.task_60258.ListOperations.filterAndSortStrings;
import static school.faang.task_60258.ListOperations.filterByAlphabetAndSortByLengthV2;
import static school.faang.task_60258.ListOperations.findUniquePairs;
import static school.faang.task_60258.ListOperations.sortCountriesAndGetCapitals;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        int target = 6;
        System.out.println("Unique pairs: " + findUniquePairs(numbers, target));

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        countries.put("France", "Paris");
        countries.put("Japan", "Tokyo");
        countries.put("Canada", "Ottawa");
        countries.put("Italy", "Rome");
        countries.put("Spain", "Madrid");
        countries.put("Brazil", "Rio de Janeiro");
        System.out.println("Capitals sorted: " + sortCountriesAndGetCapitals(countries));

        List<String> strings3 = Arrays.asList("apple", "banana", "avocado", "apricot");
        char startChar = 'a';
        System.out.println("Filtered and sorted strings: " + filterAndSortStrings(strings3, startChar));

        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4);
        System.out.println("Binary: " + convertToBinary(numbers4));

        List<String> strings5 = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "dragon фрукт");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("Filtered by alphabet and sorted: " + filterByAlphabetAndSortByLengthV2(strings5, alphabet));
    }
}
