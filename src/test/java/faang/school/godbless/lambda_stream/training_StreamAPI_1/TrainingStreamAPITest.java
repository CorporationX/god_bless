package faang.school.godbless.lambda_stream.training_StreamAPI_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TrainingStreamAPITest {
    List<Integer> nums;
    List<String> strings;

    @BeforeEach
    void setUp() {
        nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        strings = Arrays.asList("apple", "banana", "strawberry", "kiwi");
    }

    @Test
    public void testSumOfEvenNumbers() {
        int sum = TrainingStreamAPI.sumOfEvenNumbers(nums);
        assertEquals(20, sum);
    }

    @Test
    public void testMaxNumber() {
        int max = TrainingStreamAPI.maxNumber(nums);
        assertEquals(9, max);
    }

    @Test
    public void testAvgNumber() {
        double avg = TrainingStreamAPI.avgNumber(nums);
        assertEquals(5.0, avg);
    }

    @Test
    public void testCountStartingWithChar() {
        long count = TrainingStreamAPI.countStartingWithChar(strings, 'a');
        assertEquals(1, count);
    }

    @Test
    public void testOnlyStringsContainsSubstring() {
        List<String> result = TrainingStreamAPI.onlyStringsContainsSubstring(strings, "a");
        assertEquals(Arrays.asList("apple", "banana", "strawberry"), result);
    }

    @Test
    public void testSortByStringLength() {
        List<String> sorted = TrainingStreamAPI.sortByStringLength(strings);
        assertEquals(Arrays.asList("kiwi", "apple", "banana", "strawberry"), sorted);
    }

    @Test
    public void testAllElementsMatch() {
        List<Integer> evenNums = Arrays.asList(2, 4, 6, 8, 10);
        assertTrue(TrainingStreamAPI.allElementsMatch(evenNums, num -> num % 2 == 0));
    }

    @Test
    public void testMinimumMoreThan() {
        int minMoreThan = TrainingStreamAPI.minimumMoreThan(nums, 3);
        assertEquals(4, minMoreThan);
    }

    @Test
    public void testStringsToLength() {
        List<Integer> lengths = TrainingStreamAPI.stringsToLength(strings);
        assertEquals(Arrays.asList(5, 6, 10, 4), lengths);
    }
}