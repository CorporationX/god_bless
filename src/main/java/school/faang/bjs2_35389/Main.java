package school.faang.bjs2_35389;

import school.faang.bjs2_35389.util.DataProcessor;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DataProcessor dataProcessor = new DataProcessor();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int targetSum = 7;
        System.out.println(dataProcessor.findUniquePairsSumOfWhichEqualTo(numbers, targetSum));
        //[(1, 6), (2, 5), (3, 4)]

        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("USA", "Washington");
        countriesAndCapitals.put("Germany", "Berlin");
        System.out.println(dataProcessor.sortCountriesAndGetCapitals(countriesAndCapitals));
        //[Berlin, Washington, Moscow]

        List<String> strings = Arrays.asList("apple", "banana", "avocados", "apricot");
        char startChar = 'a';
        System.out.println(dataProcessor.filterAndSortStrings(strings, startChar));
        //[apple, apricot, avocados]

        List<Integer> numbers4 = Arrays.asList(1, 2, 3, 4);
        System.out.println(dataProcessor.convertNumbersToBinary(numbers4));
        //[1, 10, 11, 100]

        List<String> strings2 = Arrays.asList("apple", "banana", "", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println(dataProcessor.filterAndSortByAlphabetAndLength(strings2, alphabet));
        //[fig, date, apple, grape, banana, cherry]
    }
}
