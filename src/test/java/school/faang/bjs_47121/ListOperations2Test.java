package school.faang.bjs_47121;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ListOperations2Test {

    @Test
    void getPairOfNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int sum = 7;
        Set<List<Integer>> expected = Set.of(List.of(1, 6), List.of(2, 5), List.of(3, 4));
        Set<List<Integer>> actual = ListOperations2.getPairOfNumbers(numbers, sum);
        assertEquals(expected, actual);
    }

    @Test
    void getCapitals() {
        Map<String, String> countries = Map.of("Russia", "Moscow", "USA", "Washington",
                "Germany", "Berlin");
        List<String> expected = Arrays.asList("Berlin", "Moscow", "Washington");
        assertEquals(expected, ListOperations2.getCapitals(countries));
    }

    @Test
    void getFilteredAndSortedStrings() {
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        char letter = 'a';
        List<String> expected = Arrays.asList("apple", "avocado", "apricot");
        assertEquals(expected, ListOperations2.getFilteredAndSortedStrings(strings, letter));
    }

    @Test
    void getNumbersInBinary() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<String> expected = Arrays.asList("1", "10", "11", "100");
        assertEquals(expected, ListOperations2.getNumbersInBinary(numbers));
    }

    @Test
    void getFilteredByAlphabetAndSortedStrings() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String filterString = "abcdefghijklmnopqrstuvwxyz";
        List<String> expected = Arrays.asList("fig", "date", "apple", "grape", "banana", "cherry");
        assertEquals(expected, ListOperations2.getFilteredByAlphabetAndSortedStrings(strings, filterString));
    }
}