package lets_practice_streamapi_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class ListOperationsTest {
    private final List<Integer> NUMBERS = Arrays.asList(1, 2, 3, 4, 5, 6);
    private final List<String> STRINGS = Arrays.asList("apple", "banana", "cherry", "date");

    @Test
    void sumOfEvenNumbers() {
        assertEquals(12, ListOperations.sumOfEvenNumbers(NUMBERS));
    }

    @Test
    void findMax() {
        assertEquals(6, ListOperations.findMax(NUMBERS));
    }

    @Test
    void findAverage() {
        assertEquals(3.5, ListOperations.findAverage(NUMBERS));
    }

    @Test
    void countStringsStartingWith() {
        assertEquals(1, ListOperations.countStringsStartingWith(STRINGS, 'a'));
    }

    @Test
    void filterStringsContainingSubstring() {
        assertEquals(List.of("banana"), ListOperations.filterStringsContainingSubstring(STRINGS, "an"));
    }

    @Test
    void sortByLength() {
        assertEquals(List.of("date", "apple", "banana", "cherry"), ListOperations.sortByLength(STRINGS));
    }

    @Test
    void allMatchCondition() {
        assertFalse(ListOperations.allMatchCondition(NUMBERS, n -> n % 2 == 0));
    }

    @Test
    void findMinGreaterThan() {
        assertEquals(5, ListOperations.findMinGreaterThan(NUMBERS, 4));
    }

    @Test
    void convertToLengths() {
        assertEquals(List.of(5, 6, 6, 4), ListOperations.convertToLengths(STRINGS));
    }
}