package school.faang.task_47488;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(ListOperations.uniqueCoupleNumbers(numbers, 7));

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        System.out.println(ListOperations.countrySort(countries));

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        System.out.println(ListOperations.filterAndSorting(strings, 'a'));
        System.out.println(ListOperations.convertToBinary(Arrays.asList(1, 2, 3, 4)));
        System.out.println(ListOperations.filterByAlphabetAndSorting(
                Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape"),
                "abcdefghijklmnopqrstuvwxyz"));
    }
}
