package secondstreamapi;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

class ListOperationsTest {

    @Test
    void testFindPairs() {
        Set<Integer> numbers = Set.of(1, 2, 8, 9, 5, 6);
        int value = 7;
        Set<List<Integer>> result = ListOperations.findPairs(numbers, value);
        Set<List<Integer>> expected = Set.of(
                List.of(1, 6),
                List.of(2, 5)
        );
        assertEquals(expected, result);
    }

    @Test
    void testGetSortedCapitals() {
        Map<String, String> countriesAndCapitals = Map.of(
                "Germany", "Berlin",
                "France", "Paris",
                "Italy", "Rome"
        );
        List<String> result = ListOperations.getSortedCapitals(countriesAndCapitals);
        assertEquals(List.of("Paris", "Berlin", "Rome"), result);
    }

    @Test
    void testFilterAndSort() {
        List<String> strings = List.of("apple", "banana", "apricot", "avocado");
        char character = 'a';
        List<String> result = ListOperations.filterAndSort(strings, character);
        assertEquals(List.of("apple", "apricot", "avocado"), result);
    }

    @Test
    void testConvertToBinary() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        List<String> result = ListOperations.convertToBinary(numbers);
        assertEquals(List.of("1", "10", "11", "100", "101"), result);
    }

    @Test
    void testFilterAndSortByLength() {
        List<String> words = List.of("abc", "a", "bca", "xyz", "ab", "cba", "bac", "acb", "hello");
        String alphabet = "abc";
        List<String> result = ListOperations.filterAndSortByLength(words, alphabet);
        assertEquals(List.of("a", "ab", "abc", "bca", "cba", "bac", "acb"), result);
    }
}
