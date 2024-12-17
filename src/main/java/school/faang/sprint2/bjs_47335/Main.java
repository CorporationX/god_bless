package school.faang.sprint2.bjs_47335;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Set<List<Integer>> result = ListOperations.sumDistinctPairs(list, 7);
        System.out.println(result);

        Map<String, String> countries = Map.of("Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin");
        List<String> capitals = ListOperations.sortedCapitals(countries);
        System.out.println(capitals);

        List<String> fruits = Arrays.asList("apple", "banana", "avocado", "apricot");
        List<String> sortedFruits = ListOperations.filteredBySymbol(fruits, 'a');
        System.out.println(sortedFruits);

        List<Integer> digits = Arrays.asList(1, 2, 3, 4);
        List<String> binaryDigits = ListOperations.convertToBinary(digits);
        System.out.println(binaryDigits);

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        fruits = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        sortedFruits = ListOperations.filteredByString(fruits, alphabet);
        System.out.println(sortedFruits);
    }
}
