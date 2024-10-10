package school.faang.stream.api.one;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


class ListOperationsTest {
    private List<Integer> numbers;
    private List<String> strings;

    @BeforeEach
    public void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        strings = Arrays.asList("apple", "banana", "cherry", "date");
    }

    @Test
    void sumOfEvenNumbersTest() {
        int result = ListOperations.sumOfEvenNumbers(numbers);
        assertEquals(12, result);
    }

    @Test
    void findMaxTest() {
        int result = ListOperations.findMax(numbers);
        assertEquals(6, result);
    }

    @Test
    void findAverageTest() {
        double result = ListOperations.findAverage(numbers);
        assertEquals(3.5, result);
    }

    @Test
    void countStringsStartingWithTest() {
        double result = ListOperations.countStringsStartingWith(strings, 'a');
        assertEquals(1, result);
    }

    @Test
    void filterStringsContainingSubstringTest() {
        List<String> expected = List.of("banana");
        List<String> result = ListOperations.filterStringsContainingSubstring(strings, "an");
        assertEquals(expected, result);
    }

    @Test
    void sortByLengthTest() {
        List<String> expected = List.of("date", "apple", "banana", "cherry");
        List<String> result = ListOperations.sortByLength(strings);
        assertEquals(expected, result);
    }

    @Test
    void allMatchConditionTest() {
        boolean result = ListOperations.allMatchCondition(numbers, n -> n % 2 == 0);
        assertFalse(result);
    }

    @Test
    void findMinGreaterThanTest() {
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 3, 7);
        int result = ListOperations.findMinGreaterThan(numbers, 6);
        assertEquals(7, result);
    }

    @Test
    void convertToLengthsTest() {
        List<Integer> expected = List.of(5, 6, 6, 4);
        List<Integer> result = ListOperations.convertToLengths(strings);
        assertEquals(expected, result);
    }
}
