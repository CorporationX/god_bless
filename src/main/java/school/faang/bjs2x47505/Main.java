package school.faang.bjs2x47505;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = 7;

        System.out.println(ListOperation.findPairs(numbers, sum));

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");

        System.out.println(ListOperation.getSortedCapitals(countries));

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        char letter = 'a';

        System.out.println(ListOperation.filterAndSortLength(strings, letter));

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);

        System.out.println(ListOperation.convertorToBinary(nums));

        List<String> stringList = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        System.out.println(ListOperation.filterAndSortByLength(stringList, alphabet));
    }
}
