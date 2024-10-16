package trainingstream2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(Service.findUniquePairs(numbers, 5));

        Map<String, String> capitalCitiesByCountries = new HashMap<>();
        capitalCitiesByCountries.put("Russia", "Moscow");
        capitalCitiesByCountries.put("USA", "Washington");
        capitalCitiesByCountries.put("Germany", "Berlin");
        System.out.println(Service.getSortedCapitals(capitalCitiesByCountries));

        List<String> sortWords = new ArrayList<>(Arrays.asList("apple", "banana", "avocado", "apricot"));
        System.out.println(Service.filterAndSortByCharacter(sortWords, 'a'));

        List<Integer> convertToBinaryNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        System.out.println(Service.convertToBinary(convertToBinaryNumbers));

        List<String> filteringAndSortByLength = new ArrayList<>(
                Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape")
        );
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(Service.filterAndSortByLength(filteringAndSortByLength, alphabet));
    }
}
