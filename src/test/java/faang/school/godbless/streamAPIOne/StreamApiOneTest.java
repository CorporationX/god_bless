package faang.school.godbless.streamAPIOne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class StreamApiOneTest {

    List<Integer> numbers;
    List<String> strings;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        strings = Arrays.asList("table", "chair", "bed", "sofa");
    }

    @Test
    void testSumOfEvenNumbers() {
        int sum = StreamApiOne.sumOfEvenNumbers(numbers);
        assertEquals(12, sum);
    }

    @Test
    void testGetMax() {
        int max = StreamApiOne.getMax(numbers);
        assertEquals(6, max);
    }

    @Test
    void testGetAverageNumber() {
        double average = StreamApiOne.getAverageNumber(numbers);
        assertEquals(3.5, average);
    }

    @Test
    void testCountLinesStartsWith() {
        long count = StreamApiOne.countLinesStartsWith(strings, 'b');
        assertEquals(1, count);

    }

    @Test
    void testContainsSubstring() {
        List<String> list = StreamApiOne.containsSubstring(strings, "a");
        assertEquals(Arrays.asList("table", "chair", "sofa"), list);
    }

    @Test
    void testSortByLength() {
        List<String> sortedList = StreamApiOne.sortByLength(strings);
        assertEquals(Arrays.asList("bed", "sofa", "table", "chair"), sortedList);
    }

    @Test
    void testAreAllMatches() {
        List<Integer> evenNums = Arrays.asList(2, 4, 6);
        assertTrue(StreamApiOne.areAllMatches(evenNums, num -> num % 2 == 0));
    }

    @Test
    void testMinElemAfterProvided() {
        int minMoreThan = StreamApiOne.minElemAfterProvided(numbers, 2);
        assertEquals(3, minMoreThan);
    }

    @Test
    void testConvertStringToLength() {
        List<Integer> lengths = StreamApiOne.convertStringToLength(strings);
        assertEquals(Arrays.asList(5, 5, 3, 4), lengths);
    }
}