package sprint_2.task_47271;

import org.junit.jupiter.api.Test;
import school.faang.sprint_2.task_47271.StreamOperations;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StreamOperationsTest {
    @Test
    public void testFindUniquePairs() {
        Set<List<Integer>> validResult = Set.of(List.of(1, 6), List.of(2, 5), List.of(3, 4));

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Set<List<Integer>> result = StreamOperations.findUniquePairs(numbers, 7);

        assertEquals(validResult, result);
    }

    @Test
    public void testSortCountries() {
        List<String> validResult = List.of("Berlin", "Moscow", "Washington");

        Map<String, String> countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        List<String> result = StreamOperations.sortCountries(countries);

        assertEquals(validResult, result);
    }

    @Test
    public void testFilterAndSortStrings() {
        List<String> validResult = List.of("apple", "apricot", "avocado");

        List<String> strings = List.of("apple", "banana", "avocado", "apricot");
        List<String> result = StreamOperations.filterAndSortStrings(strings, 'a');

        assertEquals(validResult, result);
    }

    @Test
    public void testConvertToBinary() {
        List<String> validResult = List.of("1", "10", "11", "100");

        List<Integer> numbers = List.of(1, 2, 3, 4);
        List<String> result = StreamOperations.convertToBinary(numbers);

        assertEquals(validResult, result);
    }

    @Test
    public void testFilterByAlphabet() {
        List<String> validResult1 = List.of("fig", "date", "apple", "grape", "banana", "cherry");
        List<String> validResult2 = List.of("fig", "date", "grape", "banana", "cherry");

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> strings1 = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        List<String> strings2 = List.of("Apple", "banana", "cherry", "date", "fig", "grape");
        List<String> result1 = StreamOperations.filterByAlphabet(strings1, alphabet);
        List<String> result2 = StreamOperations.filterByAlphabet(strings2, alphabet);

        assertEquals(validResult1, result1);
        assertEquals(validResult2, result2);
    }
}
