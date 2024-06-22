package faang.school.godbless.BJS210555;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StreamMethodsTest {
    private List<Integer> nums;
    private List<String> strings;

    @BeforeEach
    void setUp() {
        nums = List.of(1, 2, 3, 4, 5, 6, 4, -1, -3, -4, -5, 0);
        strings = List.of("abra", "cadabra", "Argentina", "albom");
    }

    @Test
    void testGetSumEven() {
        assertEquals(12, StreamMethods.getSumEven(nums));
    }

    @Test
    void testGetMax() {
        assertEquals(6, StreamMethods.getMax(nums));
        assertThrows(IllegalArgumentException.class, () -> StreamMethods.getMax(List.of()));
    }

    @Test
    void testAverage() {
        assertEquals(1, StreamMethods.getAverage(nums));
        assertThrows(IllegalArgumentException.class, () -> StreamMethods.getAverage(List.of()));
    }

    @Test
    void testCountStringsStartedWith() {
        assertEquals(2, StreamMethods.countStringsStartedWith(strings, "a"));
    }

    @Test
    void testFilterStringsContainsOf() {
        List<String> result = List.of("abra", "cadabra");

        assertEquals(result, StreamMethods.filterStringsContainsOf(strings, "br"));
    }

    @Test
    void testSortStringsBySize() {
        List<String> result = List.of("abra", "albom", "cadabra", "Argentina");

        assertEquals(result, StreamMethods.sortStringsBySize(strings));
    }

    @Test
    void testIsStringLengthMoreThen() {
        assertEquals(true, StreamMethods.isStringLengthMoreThen(strings, 1));
        assertEquals(false, StreamMethods.isStringLengthMoreThen(strings, 4));
    }

    @Test
    void testGetMinMoreThen() {
        assertEquals(3, StreamMethods.getMinMoreThen(nums, 2));
        assertEquals(1, StreamMethods.getMinMoreThen(nums, 0));
        assertThrows(NoSuchElementException.class, () -> StreamMethods.getMinMoreThen(nums, 10));
    }

    @Test
    void testGetStringsLengths() {
        List<Integer> result = List.of(4, 7, 9, 5);

        assertEquals(result, StreamMethods.getStringsLengths(strings));
    }
}
