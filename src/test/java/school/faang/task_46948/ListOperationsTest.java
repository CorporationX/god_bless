package school.faang.task_46948;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.function.Executable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ListOperationsTest {

    @Test
    public void testSumOfEvenNumbers() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int expectedSum = 12;

        int actualSum = ListOperations.sumOfEvenNumbers(numbers);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testFindMax() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int expectedMax = 6;

        int actualMax = ListOperations.findMax(numbers);

        assertEquals(expectedMax, actualMax);
    }

    @Test
    public void testFindAverage() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        double expectedAverage = 3.5;

        double actualAverage = ListOperations.findAverage(numbers);

        assertEquals(expectedAverage, actualAverage);
    }

    @Test
    public void testCountStringsStartingWith() {
        List<String> strings = List.of("apple", "banana", "cherry", "date");
        int expectedValue = 1;

        int actualValue = ListOperations.countStringsStartingWith(strings, 'a');

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testFilterStringsContainingSubstring() {
        List<String> strings = List.of("apple", "banana", "cherry", "date");
        List<String> expectedList = List.of("banana");

        List<String> actualList = ListOperations.filterStringsContainingSubstring(strings, "an");

        assertEquals(expectedList, actualList);
    }

    @Test
    public void testSortByLength() {
        List<String> strings = List.of("apple", "banana", "cherry", "date");
        List<String> expectedList = List.of("date", "apple", "banana", "cherry");

        List<String> actualList = ListOperations.sortByLength(strings);

        assertEquals(expectedList, actualList);
    }

    @Test
    public void testAllMatchCondition() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        List<Integer> onlyEvenNumbers = List.of(2, 4, 6, 8);
        Predicate<Integer> condition = num -> num % 2 == 0;

        boolean hasOddNumbers = ListOperations.allMatchCondition(numbers, condition);
        boolean allEvenNumbers = ListOperations.allMatchCondition(onlyEvenNumbers, condition);

        assertFalse(hasOddNumbers);
        assertTrue(allEvenNumbers);
    }

    @Test
    public void testFindMinGreaterThan() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        int expectedValue = 4;

        int actualValue = ListOperations.findMinGreaterThan(numbers, 3);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void testConvertToLengths() {
        List<String> strings = List.of("apple", "banana", "cherry", "date");
        List<Integer> expectedLengths = List.of(5, 6, 6, 4);

        List<Integer> actualList = ListOperations.convertToLengths(strings);

        assertEquals(expectedLengths, actualList);
    }

    @Test
    public void testSumOfEvenNumbersWithNullList() {
        List<Integer> list = null;

        Executable executable = () -> ListOperations.sumOfEvenNumbers(list);

        assertThrows(IllegalArgumentException.class, executable,
                "List cannot be null");
    }

    @Test
    public void testSumOfEvenNumbersWithNullInList() {
        List<Integer> numbers = Arrays.asList(1, 2, null, 4, 5, 6);
        int expectedSum = 12;

        int actualSum = ListOperations.sumOfEvenNumbers(numbers);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testSumOfEvenNumbersWithEmptyList() {
        List<Integer> numbers = new ArrayList<>();

        Executable executable = () -> ListOperations.sumOfEvenNumbers(numbers);

        assertThrows(IllegalArgumentException.class, executable,
                "List cannot be empty");
    }
}