package dima.evseenko.streamapi1;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ListOperationsTest {

    @Test
    void sumOfEvenNumbers() {
        assertEquals(12, ListOperations.sumOfEvenNumbers(getNumbers()));
    }

    @Test
    void findMax() {
        assertEquals(6, ListOperations.findMax(getNumbers()));
    }

    @Test
    void findAverage() {
        assertEquals(3.6, ListOperations.findAverage(getNumbers()));
    }

    @Test
    void countStringsStartingWith() {
        assertEquals(3, ListOperations.countStringsStartingWith(getStrings(), 'a'));
    }

    @Test
    void filterStringsContainingSubstring() {
        assertEquals(List.of("apple", "application"), ListOperations.filterStringsContainingSubstring(getStrings(), "ap"));
    }

    @Test
    void sortByLength() {
        assertEquals("date", ListOperations.sortByLength(getStrings()).get(0));
    }

    @Test
    void allMatchConditionFalse() {
        assertFalse(ListOperations.allMatchCondition(getNumbers(), num -> num % 2 == 0));
    }

    @Test
    void allMatchConditionTrue() {
        assertTrue(ListOperations.allMatchCondition(List.of(2, 4, 6, 8), num -> num % 2 == 0));
    }

    @Test
    void findMinGreaterThan() {
        assertEquals(4, ListOperations.findMinGreaterThan(getNumbers(), 3));
    }

    @Test
    void convertToLengths() {
        assertEquals(List.of(5, 6, 6, 4, 6, 11), ListOperations.convertToLengths(getStrings()));
    }

    private List<Integer> getNumbers() {
        return List.of(1, 2, 4, 5, 6);
    }

    private List<String> getStrings() {
        return List.of("apple", "banana", "cherry", "date", "amazon", "application");
    }
}