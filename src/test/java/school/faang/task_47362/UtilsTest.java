package school.faang.task_47362;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void testFindPairs() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int x = 7;
        Set<List<Integer>> expected = new HashSet<>(Set.of(
                Arrays.asList(1, 6),
                Arrays.asList(2, 5),
                Arrays.asList(3, 4)
        ));
        assertEquals(expected, Utils.findPairs(numbers, x));
    }

    @Test
    void testGetSortedCapitals() {
        Map<String, String> countries = Map.of(
                "USA", "Washington",
                "Canada", "Ottawa",
                "India", "New Delhi"
        );
        List<String> expected = Arrays.asList("Ottawa", "New Delhi", "Washington");
        assertEquals(expected, Utils.getSortedCapitals(countries));
    }

    @Test
    void testFilterAndSort() {
        List<String> strings = Arrays.asList("apple", "banana", "apricot", "avocado");
        char letter = 'a';
        List<String> expected = Arrays.asList("apple", "apricot", "avocado");
        assertEquals(expected, Utils.filterAndSort(strings, letter));
    }

    @Test
    void testConvertToBinary() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<String> expected = Arrays.asList("1", "10", "11", "100", "101");
        assertEquals(expected, new Utils().convertToBinary(nums));
    }

    @Test
    void testFilterAndSortByLength() {
        List<String> strings = Arrays.asList("apple", "banana", "carrot", "applause", "ball");
        String alphabet = "abcple";
        List<String> expected = Arrays.asList("ball", "apple");
        assertEquals(expected, new Utils().filterAndSortByLength(strings, alphabet));
    }
}
