package school.faang.bjs2_35668;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class MathOperationTest {

    @Test
    public void testProcessNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        int expectedSum = 12;
        assertEquals(expectedSum, MathOperation.processNumbers(numbers));
    }

    @Test
    public void testFindMaxNumber() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int expectedMax = 5;
        assertEquals(expectedMax, MathOperation.findMaxNumber(numbers));
    }

    @Test
    public void testFindAverage() {
        List<Integer> numbers = Arrays.asList(2, 4, 6);
        double expectedAverage = 4.0;
        assertEquals(expectedAverage, MathOperation.findAverage(numbers), 0.01);
    }

    @Test
    public void testNumbersOfCharacters() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "avocado");
        int expectedCount = 2;
        assertEquals(expectedCount, MathOperation.numbersOfCharacters(strings, 'a'));
    }

    @Test
    public void testFilterList() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "avocado");
        List<String> expected = Arrays.asList("banana");
        assertEquals(expected, MathOperation.filterList(strings, "an"));
    }


    @Test
    public void testSortedList() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "kiwi");
        List<String> expected = Arrays.asList("kiwi", "apple", "banana", "cherry");
        assertEquals(expected, MathOperation.sortedList(strings));
    }

    @Test
    public void testMeetAllRequirements() {
        List<Integer> numbers = Arrays.asList(2, 4, 6);
        assertTrue(MathOperation.meetAllRequirements(numbers, n -> n % 2 == 0));
    }

    @Test
    public void testFindMinNumber() {
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15, 3, 7);
        int value = 6;
        int expectedMin = 7;
        assertEquals(expectedMin, MathOperation.findMinNumber(numbers, value));
    }

    @Test
    public void testListLength() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry", "kiwi");
        List<Integer> expected = Arrays.asList(5, 6, 6, 4);
        assertEquals(expected, MathOperation.listLength(strings));
    }
}
