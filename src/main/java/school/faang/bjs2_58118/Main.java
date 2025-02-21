package school.faang.bjs2_58118;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Map<String, String> countryCapitalMap = Map.of(
                "Russia", "Moscow", "USA", "Washington", "Germany", "Berlin"
        );
        List<String> words = Arrays.asList("apple", "banana", "avocado", "apricot");
        List<Integer> numbersList = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");

        System.out.println(StreamOperations.findPairs(numbers, 6));
        System.out.println(StreamOperations.sortedCountriesAndGetCapitals(countryCapitalMap));
        System.out.println(StreamOperations.sortedStringsByLengthStartWith(words, 'a'));
        System.out.println(StreamOperations.convertNumbersToBinaryString(numbersList));
        System.out.println(StreamOperations.filterStringsAlphabeticallyAndSortByLength(strings,
                "abcdefghijklmnopqrstuvwxyz")
        );
    }
}
