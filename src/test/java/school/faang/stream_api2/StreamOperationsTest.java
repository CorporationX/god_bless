package school.faang.stream_api2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamOperationsTest {
    @Test
    public void testFindPairs() {
        var nums = Set.of(1, 2, 3, 4, 5, 6);
        var actual = StreamOperations.findPairs(nums, 6);
        var expected = Set.of(
                new Integer[]{1, 5},
                new Integer[]{2, 4}
        );

        assertTrue(Arrays.deepEquals(expected.toArray(), actual.toArray()));
    }

    @Test
    public void testGetCapitals() {
        var countries = Map.of(
                "Russia", "Moscow",
                "USA", "Washington",
                "Germany", "Berlin"
        );
        var actual = StreamOperations.getCapitals(countries);
        var expected = List.of("Berlin", "Moscow", "Washington");
        assertEquals(expected, actual);
    }

    @Test
    public void testFilterStrings() {
        var strings = List.of("apple", "banana", "apricot", "avocado");
        var ch = 'a';
        var actual = StreamOperations.filterStringsByStartChar(strings, ch);
        var expected = List.of("apple", "apricot", "avocado");
        assertEquals(expected, actual);
    }

    @Test
    public void testConvertToBinary() {
        var nums = List.of(1, 2, 3, 4);
        var actual = StreamOperations.convertToBinary(nums);
        var expected = List.of("1", "10", "11", "100");
        assertEquals(expected, actual);
    }

    @Test
    public void testFilterStringsByAlphabet() {
        var strings = List.of("apple", "banana", "cherry", "date", "fig", "grape");
        var alphabet = "abcdefghijklmnopqrstuvwxyz";
        var actual = StreamOperations.filterStringsByAlphabet(strings, alphabet);
        var expected = List.of("fig", "date", "apple", "grape", "banana", "cherry");
        assertEquals(expected, actual);
    }
}
