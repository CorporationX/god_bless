package school.faang.streamapi2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int target = 7;
        System.out.println("Input: " + numbers + ", target number: " + target);
        Map<Integer, Integer> pairs = ListOperation.findPairsOfNumbers(numbers, target);
        pairs.forEach((key, value) -> System.out.println("(" + key + ", " + value + ")"));

        Map<String, String> countryCapitals = new HashMap<>();
        countryCapitals.put("Russia", "Moscow");
        countryCapitals.put("USA", "Washington");
        countryCapitals.put("Germany", "Berlin");
        System.out.println(countryCapitals);
        System.out.println(ListOperation.sortByCountry(countryCapitals));

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot", "ddd", "asdqwezxc");
        char startChar = 'a';
        System.out.println(ListOperation.filterAndSort(strings, startChar));

        List<String> binaryStrings = ListOperation.convertToBinary(numbers);
        System.out.println(binaryStrings);

        List<String> strings1 = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "jkj4k");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(ListOperation.filterAndSort(strings1, alphabet));

    }
}
