package school.faang.bjs2_35389.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DataProcessorTest {
    private final DataProcessor dataProcessor = new DataProcessor();

    @Test
    void findUniquePairsSumOfWhichEqualTo() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int targetSum = 7;
        List<PairInteger> correctResult = Arrays.asList(
                new PairInteger(1, 6),
                new PairInteger(2, 5),
                new PairInteger(3, 4)
        );
        List<PairInteger> result = dataProcessor.findUniquePairsSumOfWhichEqualTo(numbers, targetSum);
        assertEquals(correctResult, result);
    }

    @Test
    void sortCountriesAndGetCapitals() {
        Map<String, String> countriesAndCapitals = new HashMap<>();
        countriesAndCapitals.put("Russia", "Moscow");
        countriesAndCapitals.put("USA", "Washington");
        countriesAndCapitals.put("Germany", "Berlin");
        List<String> correctResult = Arrays.asList("Berlin", "Moscow", "Washington");
        List<String> result = dataProcessor.sortCountriesAndGetCapitals(countriesAndCapitals);
        assertEquals(correctResult, result);
    }

    @Test
    void filterAndSortStrings() {
        List<String> strings = Arrays.asList("apple", "banana", "avocados", "apricot");
        char startChar = 'a';
        List<String> correctResult = Arrays.asList("apple", "apricot", "avocados");
        List<String> result = dataProcessor.filterAndSortStrings(strings, startChar);
        assertEquals(correctResult, result);
    }

    @Test
    void convertNumbersToBinary() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<String> correctResult = Arrays.asList("1", "10", "11", "100");
        List<String> result = dataProcessor.convertNumbersToBinary(numbers);
        assertEquals(correctResult, result);
    }

    @Test
    void filterAndSortByAlphabetAndLength() {
        List<String> strings = Arrays.asList("apple", "banana", "", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> correctResult = Arrays.asList("fig", "date", "apple", "grape", "banana", "cherry");
        List<String> result = dataProcessor.filterAndSortByAlphabetAndLength(strings, alphabet);
        assertEquals(correctResult, result);
    }
}