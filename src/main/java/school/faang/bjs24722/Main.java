package school.faang.bjs24722;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("China", "Beijing");
        countriesAndCapitals.put("India", "New Delhi");
        countriesAndCapitals.put("Germany", "Berlin");
        countriesAndCapitals.put("France", "Paris");
        countriesAndCapitals.put("Brazil", "Brasília");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot", "apricots", "Cherry");

        System.out.println("Unique pairs of numbers: " + ListOperations.findUniquePairsOfNumbers(numbers, 7));
        System.out.println("Capitals: " + ListOperations.sortCountriesAndEnterCapitals(countriesAndCapitals));
        System.out.println(ListOperations.filterAndSortByLength(strings, 'a'));
        System.out.println("Binary numbers: " + ListOperations.mapToBinaryAsStrings(numbers));
        System.out.println(ListOperations.filterByAbcAndSortAscStrings(strings, "abcdefghijklmnopqrstuvwxyz"));
    }
}