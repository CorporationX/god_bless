package school.faang.sprint_2.task_47049;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    void testFindUniquePairsBaseCase() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int targetNumber = 5;
        var expectedValue = Set.of(
                List.of(1, 4),
                List.of(2, 3)
        );

        var actualSet = Main.findUniquePairs(numbers, targetNumber);

        assertEquals(expectedValue, actualSet);
    }

    @Test
    void testFindUniquePairsWithDuplicates() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        int targetNumber = 5;
        var expectedValue = Set.of(
                List.of(1, 4),
                List.of(2, 3)
        );

        var actualSet = Main.findUniquePairs(numbers, targetNumber);

        assertEquals(expectedValue, actualSet);
    }

    @Test
    void testFindUniquePairsWithNoPairs() {
        List<Integer> numbers = Arrays.asList(1, 2, 3);
        int targetNumber = 10;
        var expectedValue = new HashSet<>();

        var actualSet = Main.findUniquePairs(numbers, targetNumber);

        assertEquals(expectedValue, actualSet);
    }

    @Test
    void testFindUniquePairsEmptyList() {
        List<Integer> numbers = new ArrayList<>();
        int targetNumber = 5;

        Set<List<Integer>> expected = new HashSet<>();
        Set<List<Integer>> actual = Main.findUniquePairs(numbers, targetNumber);

        assertEquals(expected, actual);
    }

    @Test
    void testFindUniquePairsMixedNumbers() {
        List<Integer> numbers = Arrays.asList(-1, -2, -3, 3, 4, 1);
        int targetNumber = 1;
        var expectedValue = Set.of(
                List.of(-3, 4),
                List.of(-2, 3)
        );

        var actualSet = Main.findUniquePairs(numbers, targetNumber);

        assertEquals(expectedValue, actualSet);
    }

    @Test
    void testGetSortedCapitalsBaseCase() {
        Map<String, String> countriesCapitals = new HashMap<>();
        countriesCapitals.put("France", "Paris");
        countriesCapitals.put("Germany", "Berlin");
        countriesCapitals.put("Italy", "Rome");
        var expectedValue = List.of("Paris", "Berlin", "Rome");

        var actualValue = Main.getSortedCapitals(countriesCapitals);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGetSortedCapitalsWithEmptyMap() {
        Map<String, String> countriesCapitals = new HashMap<>();
        var expectedValue = new ArrayList<>();

        var actualValue = Main.getSortedCapitals(countriesCapitals);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testFilterAndSortStringWithMatchingStrings() {
        List<String> input = List.of("apple", "banana", "apricot", "cherry", "avocado");
        List<String> expected = List.of("apple", "apricot", "avocado");

        List<String> result = Main.filterAndSortString(input, 'a');

        assertEquals(expected, result);
    }

    @Test
    void testFilterAndSortStringWithNoMatchingStrings() {
        List<String> input = List.of("banana", "cherry", "date");
        List<String> expected = List.of();

        List<String> result = Main.filterAndSortString(input, 'a');

        assertEquals(expected, result);
    }

    @Test
    void testFilterAndSortStringWithEmptyList() {
        List<String> input = List.of();
        List<String> expected = List.of();

        List<String> result = Main.filterAndSortString(input, 'a');

        assertEquals(expected, result);
    }

    @Test
    void testFilterAndSortStringWithCaseSensitiveMatch() {
        List<String> input = List.of("Apple", "apple", "apricot", "Avocado", "avocado");
        List<String> expected = List.of("apple", "apricot", "avocado");

        List<String> result = Main.filterAndSortString(input, 'a');

        assertEquals(expected, result);
    }

    @Test
    void testMapToBinaryBasicCase() {
        var numbers = List.of(1, 2, 3, 4);
        var expectedValue = List.of("1", "10", "11", "100");

        var actual = Main.mapToBinary(numbers);

        assertEquals(expectedValue, actual);
    }

    @Test
    void testMapToBinaryEmptyList() {
        List<Integer> numbers = List.of();
        List<String> expectedValue = List.of();

        var actual = Main.mapToBinary(numbers);

        assertEquals(expectedValue, actual);
    }

    @Test
    void testFilterByAlphabetAndSortBaseCase() {
        var strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        var alphabet = "abcdefghijklmnopqrstuvwxyz";
        var expectedStrings = List.of("fig", "date", "apple", "grape", "banana", "cherry");

        var actualStrings = Main.filterByAlphabetAndSort(strings, alphabet);

        assertEquals(expectedStrings, actualStrings);
    }

    @Test
    void testFilterByAlphabetAndSortWithNoMatch() {
        var strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        var alphabet = "abcdeghij";
        var expectedStrings = new ArrayList<String>();

        var actualStrings = Main.filterByAlphabetAndSort(strings, alphabet);

        assertEquals(expectedStrings, actualStrings);
    }
}
