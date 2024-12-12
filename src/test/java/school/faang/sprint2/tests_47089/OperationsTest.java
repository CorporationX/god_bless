package school.faang.sprint2.tests_47089;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import school.faang.sprint2.task_47089.Operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class OperationsTest {

    private Operations operations;

    @BeforeEach
    void setUp() {
        operations = new Operations();
    }

    @Test
    void testFindPairsValid() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int sum = 7;
        Set<List<Integer>> expected = new HashSet<>(Set.of(Arrays.asList(1, 6),
                Arrays.asList(2, 5), Arrays.asList(3, 4)));

        Set<List<Integer>> result = operations.findPairs(numbers, sum);

        assertEquals(expected, result);
    }

    @Test
    void testFindPairsListNull() {
        List<Integer> numbers = null;
        int sum = 7;

        assertThrows(NullPointerException.class, () -> operations.findPairs(numbers, sum));
    }

    @Test
    void testSortCapitalsOfCountries() {
        Map<String, String> countryToCapital = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        List<String> expected = List.of("Berlin", "Moscow", "Washington");

        List<String> result = operations.sortCapitalsOfCountries(countryToCapital);

        assertEquals(expected, result);
    }

    @Test
    void testSortByLengthStartingWith() {
        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        char firstLetter = 'a';
        List<String> expected = List.of("apple", "avocado", "apricot");

        List<String> result = operations.sortByLengthStartingWith(strings, firstLetter);

        assertEquals(expected, result);
    }

    @Test
    void testConvertToBinary() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<String> expected = List.of("1", "10", "11", "100", "101");

        List<String> result = operations.convertToBinary(numbers);

        assertEquals(expected, result);
    }

    @Test
    void testFilterStringsFromAlphabetSortByLength() {
        List<String> list = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> expected = List.of("fig", "date", "apple", "grape", "banana", "cherry");

        List<String> result = operations.filterStringsFromAlphabetSortByLength(list, alphabet);

        assertEquals(expected, result);
    }
}
