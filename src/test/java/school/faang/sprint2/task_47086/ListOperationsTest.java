package school.faang.sprint2.task_47086;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListOperationsTest {

    @Test
    public void testSumOfEvenNumbers() {
        List<Integer> integerList = List.of(1, 3, 4, 14);
        List<Integer> oddIntegersList = List.of(1, 3, 11);

        int sum = ListOperations.sumOfEvenNumbers(integerList);
        int sumNoEven = ListOperations.sumOfEvenNumbers(oddIntegersList);

        assertEquals(18, sum);
        assertEquals(0, sumNoEven);
    }

    @Test
    public void testFindMax() {
        List<Integer> integerList = List.of(-1, -5, 12);

        int max = ListOperations.findMax(integerList);

        assertEquals(12, max);
        assertThrows(NoSuchElementException.class, () -> ListOperations.findMax(List.of()));
    }

    @Test
    public void testFindAverage() {
        List<Integer> integerList = List.of(-1, -5, 12);

        double average = ListOperations.findAverage(integerList);

        assertEquals(2.0, average);
        assertThrows(NoSuchElementException.class, () -> ListOperations.findAverage(List.of()));
    }

    @Test
    public void testCountStringsStartingWith() {
        List<String> stringList = List.of("hello bob", "hell is unreal", "popcorn", "hello john!");

        int count = ListOperations.countStringsStartingWith(stringList, 'h');

        assertEquals(3, count);
        assertEquals(0, ListOperations.countStringsStartingWith(List.of(), 'a'));
    }

    @Test
    public void testFilterStringsContainingSubstring() {
        List<String> stringList = List.of("hello bob", "hell is unreal", "popcorn", "hello john!");
        List<String> filteredStringList = List.of("hello bob", "hello john!");

        assertEquals(filteredStringList, ListOperations.filterStringsContainingSubstring(stringList, "llo "));
        assertEquals(stringList, ListOperations.filterStringsContainingSubstring(stringList, ""));
        assertEquals(List.of(), ListOperations.filterStringsContainingSubstring(List.of(), "any"));
    }

    @Test
    public void testSortByLength() {
        List<String> stringList = List.of("A", "AAAA", "AAA", "AA", "");
        List<String> orderedStringList = List.of("", "A", "AA", "AAA", "AAAA");

        assertEquals(orderedStringList, ListOperations.sortByLength(stringList));
    }

    @Test
    public void testAllMatchCondition() {
        List<Integer> mixedNumbers = List.of(1, 3, 2, 8);
        List<Integer> evenNumbers = List.of(2, 6, 20, 4);
        Predicate<Integer> isEven = n -> n % 2 == 0;

        assertFalse(ListOperations.allMatchCondition(mixedNumbers, isEven));
        assertTrue(ListOperations.allMatchCondition(evenNumbers, isEven));
    }

    @Test
    public void testFindMinGreaterThan() {
        List<Integer> numbers = List.of(-2, -10, 34, 10, 1);

        assertEquals(10, ListOperations.findMinGreaterThan(numbers, 2));
        assertThrows(NoSuchElementException.class, () -> ListOperations.findMinGreaterThan(numbers, 100));
    }

    @Test
    public void testConvertToLengths() {
        List<String> stringList = List.of("A", "AAAA", "AAA", "AA", "");
        List<Integer> stringLengthsList = List.of(1, 4, 3, 2, 0);

        assertEquals(stringLengthsList, ListOperations.convertToLengths(stringList));
    }
}
