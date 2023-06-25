package faang.school.godbless;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamProcessTest {
    @Test
    public void testSumOfEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        int expectedSum = 30;

        int actualSum = StreamProcess.sumOfEvenNumbers(numbers);

        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void testFindMax() {
        List<Integer> numbers = Arrays.asList(1, 8, 3, 5, 2, 9, 4, 7, 6);
        int expectedMax = 9;

        int actualMax = StreamProcess.findMax(numbers);

        assertEquals(expectedMax, actualMax);
    }

    @Test
    public void testFindAverage() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        double expectedAverage = 3.0;

        double actualAverage = StreamProcess.findAverage(numbers);

        assertEquals(expectedAverage, actualAverage, 0.001);
    }

    @Test
    public void testCountStringsWithPrefix() {
        List<String> strings = Arrays.asList("apple", "banana", "cat", "dog", "elephant");
        char prefix = 'b';
        long expectedCount = 1;

        long actualCount = StreamProcess.countStringWithPrefix(strings, prefix);

        assertEquals(expectedCount, actualCount);
    }

    @Test
    public void testFilterStringsBySubstring() {
        List<String> strings = Arrays.asList("apple", "banana", "cat", "dog", "elephant");
        String substring = "e";
        List<String> expectedFilteredStrings = Arrays.asList("apple", "elephant");

        List<String> actualFilteredStrings = StreamProcess.filterStringBySubstring(strings, substring);

        assertEquals(expectedFilteredStrings, actualFilteredStrings);
    }

    @Test
    public void testSortStringByLength() {
        List<String> strings = Arrays.asList("apple", "banana", "cat", "dog", "elephant");
        List<String> expectedSortedStrings = Arrays.asList("cat", "dog", "apple", "banana", "elephant");

        List<String> actualSortedStrings = StreamProcess.sortStringByLength(strings);

        assertEquals(expectedSortedStrings, actualSortedStrings);
    }

    @Test
    public void testAllElementsPredicate() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10);
        int condition = 2;

        boolean allMatch = StreamProcess.allElementsPredicate(numbers, condition);

        assertTrue(allMatch);
    }

    @Test
    public void testFindSmallerNumber() {
        List<Integer> numbers = Arrays.asList(1, 3, 5, 7, 9);
        int target = 4;
        int expectedSmallest = 5;

        int actualSmallest = StreamProcess.findSmallerNumber(numbers, target);

        assertEquals(expectedSmallest, actualSmallest);
    }

    @Test
    public void testConvertStringsLength() {
        List<String> strings = Arrays.asList("apple", "banana", "cat", "dog", "elephant");
        List<Integer> expectedLengthList = Arrays.asList(5, 6, 3, 3, 8);

        List<Integer> actualLengthList = StreamProcess.convertStringsToLength(strings);

        assertEquals(expectedLengthList, actualLengthList);
    }
}