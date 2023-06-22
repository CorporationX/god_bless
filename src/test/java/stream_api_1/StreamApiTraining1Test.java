package stream_api_1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StreamApiTraining1Test {

    private List<Integer> numbers;
    private List<String> strings;

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        strings = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
    }

    @Test
    void testSumOfEven() {
        // Given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // When
        int sum = StreamApiTraining1.sumOfEven(numbers);

        // Then
        assertEquals(30, sum);
    }

    @Test
    void testMax() {
        // When
        OptionalInt max = StreamApiTraining1.max(numbers);

        // Then
        assertTrue(max.isPresent());
        assertEquals(10, max.getAsInt());
    }

    @Test
    void testAverage() {
        // When
        OptionalDouble average = StreamApiTraining1.average(numbers);

        // Then
        assertTrue(average.isPresent());
        assertEquals(5.5, average.getAsDouble());
    }

    @Test
    void testCountStringsStartingWith() {
        // When
        long count = StreamApiTraining1.countStringsStartingWith(strings, 'b');

        // Then
        assertEquals(1, count);
    }

    @Test
    void testFilterBySubstring() {
        // When
        List<String> filteredStrings = StreamApiTraining1.filterBySubstring(strings, "rr");

        // Then
        assertEquals(Arrays.asList("cherry", "elderberry"), filteredStrings);
    }

    @Test
    void testSortByLength() {
        // When
        List<String> sortedStrings = StreamApiTraining1.sortByLength(strings);

        // Then
        assertEquals(Arrays.asList("date", "apple", "banana", "cherry", "elderberry"), sortedStrings);
    }

    @Test
    void testAllMatch() {
        // Given
        Predicate<Integer> condition = n -> n > 0;

        // When
        boolean allMatch = StreamApiTraining1.allMatch(numbers, condition);

        // Then
        assertTrue(allMatch);
    }

    @Test
    void testSmallestElementGreaterThan() {
        // When
        Optional<Integer> smallestElement = StreamApiTraining1.smallestElementGreaterThan(numbers, 7);

        // Then
        assertTrue(smallestElement.isPresent());
        assertEquals(8, smallestElement.get());
    }

    @Test
    void testConvertToLength() {
        // When
        List<Integer> lengths = StreamApiTraining1.convertToLength(strings);

        // Then
        assertEquals(Arrays.asList(5, 6, 6, 4, 10), lengths);
    }
}
