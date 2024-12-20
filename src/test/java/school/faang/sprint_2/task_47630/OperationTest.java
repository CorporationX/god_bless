package school.faang.sprint_2.task_47630;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    void testFindPairs() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int target = 7;
        List<int[]> expected = List.of(new int[]{1, 6}, new int[]{2, 5}, new int[]{3, 4});

        List<int[]> result = Operation.findPairs(numbers, target);

        result.sort((a, b) -> {
            int compareFirst = Integer.compare(a[0], b[0]);
            return compareFirst != 0 ? compareFirst : Integer.compare(a[1], b[1]);
        });

        assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            assertArrayEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    void testSortCapitals() {
        Map<String, String> countryCapitalMap = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        List<String> expected = List.of("Berlin", "Moscow", "Washington");
        List<String> result = Operation.sortCapitals(countryCapitalMap);

        assertEquals(expected, result);
    }

    @Test
    void testFilterAndSortStrings() {
        List<String> strings = Arrays.asList("apple", "banana", "avocado", "apricot");
        char startChar = 'a';
        List<String> expected = List.of("apple", "apricot", "avocado");
        List<String> result = Operation.filterAndSortStrings(strings, startChar);

        assertEquals(expected, result);
    }

    @Test
    void testConvertToBinary() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<String> expected = List.of("1", "10", "11", "100");
        List<String> result = Operation.convertToBinary(numbers);

        assertEquals(expected, result);
    }

    @Test
    void testFilterByAlphabetAndSort() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        List<String> expected = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        List<String> result = Operation.filterByAlphabetAndSort(strings, alphabet);

        assertEquals(expected, result);
    }

    @Test
    void testFilterByAlphabetAndSortWithRestrictedAlphabet() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "date", "fig", "grape");
        String alphabet = "abcdefg";
        List<String> expected = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        List<String> result = Operation.filterByAlphabetAndSort(strings, alphabet);

        assertEquals(expected, result);
    }

}
