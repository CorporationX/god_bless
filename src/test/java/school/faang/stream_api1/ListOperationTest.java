package school.faang.stream_api1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ListOperationTest {
    private List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    private List<String> strings = Arrays.asList("apple", "banana", "cherry", "date");

    @Test
    public void testSumOfEvenNumbers() {
        assertEquals(12, ListOperations.sumOfEvenNumbers(numbers));
    }

    @Test
    public void testFindMax() {
        assertEquals(6, ListOperations.findMax(numbers));
    }

    @Test
    public void testFindAverage() {
        assertEquals(3.5, ListOperations.findAverage(numbers));
    }

    @Test
    public void testCountStringsStartingWith() {
        var actual = ListOperations.countStringsStartingWith(strings, 'a');
        assertEquals(1, actual);
    }

    @Test
    public void testFilterStringsContainingSubstring() {
        var expected = List.of("banana");
        var actual = ListOperations.filterStringsContainingSubstring(strings, "an");
        assertEquals(expected, actual);
    }

    @Test
    public void testSortByLength() {
        var expected = List.of("date", "apple", "banana", "cherry");
        var actual = ListOperations.sortByLength(strings);
        assertEquals(expected, actual);
    }

    @Test
    public void testAllMatchCondition() {
        assertFalse(ListOperations.allMatchCondition(numbers, n -> n % 2 == 0));
    }

    @Test
    public void testFindMinGreaterThan() {
        assertEquals(5, ListOperations.findMinGreaterThan(numbers, 4));
        Exception exception = assertThrows(NoSuchElementException.class,
                () -> ListOperations.findMinGreaterThan(numbers, 6));
        assertEquals("not found", exception.getMessage());
    }

    @Test()
    public void testConvertToLength() {
        var expected = List.of(5, 6, 6, 4);
        assertEquals(expected, ListOperations.convertToLengths(strings));
    }
}
