package faang.school.godbless.streamapi_1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class StreamLibTest {
    @Test
    public void testEvenList() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        Integer expected = 12;
        assertEquals(expected, StreamLib.evenList(input));
    }

    @Test
    public void testMaxNumber() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        int expected = 6;
        assertEquals(expected, StreamLib.maxNumber(input));
    }

    @Test
    public void testAverageList() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        double expected = 3.5;
        assertEquals(expected, StreamLib.averageList(input));
    }

    @Test
    public void testGrepCount() {
        List<String> input = Arrays.asList("apple", "banana", "apricot", "blueberry");
        String pattern = "a";
        int expected = 2;
        assertEquals(expected, StreamLib.grepCount(input, pattern));
    }

    @Test
    public void testRegexFilter() {
        List<String> input = Arrays.asList("apple", "banana", "strawberry", "apricot", "blueberry");
        String pattern = "berry";
        List<String> expected = Arrays.asList("strawberry", "blueberry");
        assertEquals(expected, StreamLib.regexFilter(input, pattern));
    }

    @Test
    public void testStringLengthSorter() {
        List<String> input = Arrays.asList("apple", "banana", "apricot", "blueberry");
        List<String> expected = Arrays.asList("apple", "banana", "apricot", "blueberry");
        assertEquals(expected, StreamLib.stringLengthSorter(input));
    }

    @Test
    public void testCustomFilter() {
        List<Integer> input = Arrays.asList(2, 4, 6, 8);
        Predicate<Integer> predicate = num -> num % 2 == 0;
        assertTrue(StreamLib.customFilter(input, predicate));
    }

    @Test
    public void testMinMax() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5, 6);
        int min = 3;
        int expected = 3;
        assertEquals(expected, StreamLib.minMax(input, min));
    }

    @Test
    public void testStringLengths() {
        List<String> input = Arrays.asList("apple", "banana", "apricot", "blueberry");
        List<Integer> expected = Arrays.asList(5, 6, 7, 9);
        assertEquals(expected, StreamLib.stringLengths(input));
    }
}