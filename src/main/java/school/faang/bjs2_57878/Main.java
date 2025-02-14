package school.faang.bjs2_57878;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> seen = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<String> fruits = Arrays.asList("apple", "banana", "avocado", "apricot");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        Map<String, String> countries = new HashMap<>();
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");

        System.out.println(CollectionOperations.findUniquePairs(seen, 6));
        System.out.println(CollectionOperations.sortCountriesByName(countries));
        System.out.println(CollectionOperations.filterAndSortStrings(fruits, 'a'));
        System.out.println(CollectionOperations.convertToBinary(numbers));
        System.out.println(CollectionOperations.filterByAlphabetAndSort(strings, alphabet));
    }
}
