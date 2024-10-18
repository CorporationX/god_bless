package school.faang.stream_2.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<String, String> CITIES = new HashMap<>();

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Output " + ListOfSorting.findPairs(numbers, 7));
        List<String> countriesAndCountries = Arrays.asList("Russia", "United States", "France");

        CITIES.put("Paris", countriesAndCountries.get(2));
        CITIES.put("Los-Angeles", "United States");
        CITIES.put("Chicago", countriesAndCountries.get(1));
        CITIES.put("Moscow", countriesAndCountries.get(0));
        System.out.println("Sorted Cities are: " + ListOfSorting.getListOfCountriesAndCapitalsSortedBy(CITIES));

        for (Map.Entry<String, String> entry : CITIES.entrySet()) {
            System.out.println("Countries and Cities " + entry.getKey());
        }

        List<String> fruits = Arrays.asList("apple", "banana", "avocado", "apricot");
        System.out.println("Sorted fruits by a letter " + ListOfSorting.getSortedList(fruits, 'a'));

        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        System.out.println("Numbers in binary " + ListOfSorting.findPairs(nums, 2));

        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape", "apricot", "watermelon");
        System.out.println("The words by length are " + ListOfSorting.filterAndSortByLength(strings, "abcdefghijklmnopqrstuvwxyz"));
    }
}
