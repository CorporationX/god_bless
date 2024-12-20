package school.faang.trainstreamapi2bjs47485;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    private static final char FILTERCHAR = 'a';
    private static final int TARGET = 7;

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Unique pairs: "
                + Utility.findUniquePairs(numbers, TARGET));

        Map<String, String> countries = new HashMap<>();
        countries.put("Russia", "Moscow");
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        System.out.println("Capitals sorted by countries: "
                + Utility.sortCountriesAndGetCapitals(countries));

        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        System.out.println("Filtered and sorted strings: "
                + Utility.filterAndSortStrings(strings, FILTERCHAR));

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        System.out.println("Numbers in binary: "
                + Utility.convertNumbersToBinary(nums));

        List<String> stringList = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        System.out.println("Filtered and sorted by alphabet: "
                + Utility.filterAndSortByAlphabet(stringList, ALPHABET));

    }
}
