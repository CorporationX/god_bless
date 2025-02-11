import org.junit.jupiter.api.Test;
import school.faang.Operations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperationsTest {
    @Test
    void testFindPairs_WithValidPairs() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        int sum = 7;
        Set<List<Integer>> expected = new HashSet<>(Arrays.asList(
                Arrays.asList(1, 6),
                Arrays.asList(2, 5),
                Arrays.asList(3, 4)
        ));
        assertEquals(expected, Operations.findPairs(numbers, sum));
    }

    @Test
    void testFindPairs_NoPairsFound() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 3));
        int sum = 10;
        Set<List<Integer>> expected = new HashSet<>();
        assertEquals(expected, Operations.findPairs(numbers, sum));
    }

    @Test
    void testFindPairs_WithDuplicateNumbers() {
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1, 2, 2, 3, 4, 5, 6));
        int sum = 7;
        Set<List<Integer>> expected = new HashSet<>(Arrays.asList(
                Arrays.asList(1, 6),
                Arrays.asList(2, 5),
                Arrays.asList(3, 4)
        ));
        assertEquals(expected, Operations.findPairs(numbers, sum));
    }

    @Test
    void testFindPairs_WithEmptySet() {
        Set<Integer> numbers = new HashSet<>();
        int sum = 5;
        Set<List<Integer>> expected = new HashSet<>();
        assertEquals(expected, Operations.findPairs(numbers, sum));
    }

    @Test
    void testFindPairs_WithSingleElementSet() {
        Set<Integer> numbers = new HashSet<>(Collections.singletonList(3));
        int sum = 6;
        Set<List<Integer>> expected = new HashSet<>();
        assertEquals(expected, Operations.findPairs(numbers, sum));
    }


    @Test
    void testGetSortedCapitals_WithValidMap() {
        Map<String, String> countries = new HashMap<>();
        countries.put("USA", "Washington");
        countries.put("Germany", "Berlin");
        countries.put("France", "Paris");
        List<String> expected = Arrays.asList("Berlin", "Paris", "Washington");
        List<String> actual = Operations.getSortedCapitals(countries);
        assertEquals(expected, actual);
    }

    @Test
    void testGetSortedCapitals_EmptyMap() {
        Map<String, String> countries = new HashMap<>();
        List<String> result = Operations.getSortedCapitals(countries);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetSortedCapitals_SingleEntry() {
        Map<String, String> countries = new HashMap<>();
        countries.put("Japan", "Tokyo");
        List<String> result = Operations.getSortedCapitals(countries);
        assertEquals(List.of("Tokyo"), result);
    }

    @Test
    void testGetSortedCapitals_NullMap() {
        assertThrows(IllegalArgumentException.class, () -> Operations.getSortedCapitals(null));
    }


    @Test
    void testFilterAndSort_WithMatching() {
        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        assertEquals(List.of("apple", "avocado", "apricot"), Operations.filterAndSort(strings, 'a'));
    }

    @Test
    void testFilterAndSort_WithoutMatching() {
        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        assertEquals(new ArrayList<>(), Operations.filterAndSort(strings, 'n'));
    }

    @Test
    void testFilterAndSort_EmptyList() {
        assertEquals(new ArrayList<>(), Operations.filterAndSort(new ArrayList<>(), 'a'));
    }

    @Test
    void testFilterAndSort_DifferentCases() {
        List<String> input = List.of("Apple", "apricot", "Avocado", "apple");
        List<String> expected = List.of("apple", "apricot");
        assertEquals(expected, Operations.filterAndSort(input, 'a'));
    }

    @Test
    void testFilterAndSort_SortedOrder() {
        List<String> input = List.of("apple", "apricot", "avocado");
        List<String> expected = List.of("apple", "apricot", "avocado");
        assertEquals(expected, Operations.filterAndSort(input, 'a'));
    }

    @Test
    void testFilterAndSort_NullList() {
        assertThrows(IllegalArgumentException.class, () -> Operations.filterAndSort(null, 'a'));
    }


    @Test
    void testConvertToBinary_WithPositiveNumbers() {
        List<String> expected = List.of("1", "10", "11", "100", "101");
        assertEquals(expected, Operations.convertToBinary(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    void testConvertToBinary_Zero() {
        assertEquals(List.of("0"), Operations.convertToBinary(List.of(0)));
    }

    @Test
    void testConvertToBinary_WithNegativeNumbers() {
        List<Integer> input = List.of(-1, -2, -3);
        List<String> expected = List.of(Integer.toBinaryString(-1),
                Integer.toBinaryString(-2), Integer.toBinaryString(-3));
        assertEquals(expected, Operations.convertToBinary(input));
    }

    @Test
    void testConvertToBinary_WithMixedNumbers() {
        List<String> expected = List.of(Integer.toBinaryString(10), Integer.toBinaryString(-10),
                Integer.toBinaryString(15), Integer.toBinaryString(-15));
        assertEquals(expected, Operations.convertToBinary(List.of(10, -10, 15, -15)));
    }

    @Test
    void testConvertToBinary_EmptyList() {
        assertEquals(new ArrayList<>(), Operations.convertToBinary(new ArrayList<>()));
    }

    @Test
    void testConvertToBinary_NullList() {
        assertThrows(IllegalArgumentException.class, () -> Operations.convertToBinary(null));
    }


    @Test
    void testFilterAndSortByLength_WithValidStrings() {
        List<String> input = List.of("apple", "banana", "apricot", "grape", "avocado");
        assertEquals(List.of("apple", "grape"), Operations.filterAndSortByLength(input, "aplegr"));
    }

    @Test
    void testFilterAndSortByLength_NoMatchingStrings() {
        List<String> input = List.of("banana", "cherry", "kiwi");
        assertEquals(new ArrayList<>(), Operations.filterAndSortByLength(input, "xyz"));
    }

    @Test
    void testFilterAndSortByLength_EmptyList() {
        assertEquals(new ArrayList<>(), Operations.filterAndSortByLength(new ArrayList<>(), "abc"));
    }

    @Test
    void testFilterAndSortByLength_CaseSensitivity() {
        List<String> input = List.of("Apple", "apple", "Avocado", "grape");
        assertEquals(List.of("apple"), Operations.filterAndSortByLength(input, "aple"));
    }

    @Test
    void testFilterAndSortByLength_SortedStrings() {
        List<String> input = List.of("ant", "ape", "arc");
        List<String> expected = List.of("ant", "ape", "arc");
        assertEquals(expected, Operations.filterAndSortByLength(input, "antpearc"));
    }

    @Test
    void testFilterAndSortByLength_NullList() {
        assertThrows(IllegalArgumentException.class, () ->
                Operations.filterAndSortByLength(null, "abc"));
    }

    @Test
    void testFilterAndSortByLength_NullAlphabet() {
        List<String> input = List.of("apple", "banana");
        assertThrows(IllegalArgumentException.class, () -> Operations.filterAndSortByLength(input, null));
    }
}
