package faang.school.godbless.sprint3.stream_api1;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UtilsTest {

    @Test
    void sum() {
        List<Integer> nums = List.of(1, 1, 2, 3, 4, 5, 6, 7, 8);
        int expected = 37;

        assertEquals(expected, Utils.sum(nums));
    }

    @Test
    void max() {
        List<Integer> nums = List.of(1, 1, 2, 3, 7);
        int expected = 7;

        assertEquals(expected, Utils.max(nums));
    }

    @Test
    void max_shouldThrowNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> Utils.max(Collections.emptyList()));
    }

    @Test
    void average() {
        List<Integer> nums = List.of(0, 13, 5, 7, 0);
        double expected = 5.0;

        assertEquals(expected, Utils.average(nums));
    }

    @Test
    void average_shouldThrowNoSuchElementException() {
        assertThrows(NoSuchElementException.class, () -> Utils.average(Collections.emptyList()));
    }

    @Test
    void getStringsStartingWithSpecificCharCount() {
        List<String> stringList = List.of("java", "junior", "python", "JSON");
        long expected = 2;

        assertEquals(expected, Utils.getCountOfStringsStartingWithSpecificChar(stringList, 'j'));
    }

    @Test
    void getStringsContainingSpecificSubstring() {
        List<String> stringList = List.of("java", "junior", "python", "JSON");
        List<String> expected = List.of("java");

        assertEquals(expected, Utils.getListContainingSpecificSubstring(stringList, "ja"));
    }

    @Test
    void sortByLength() {
        List<String> stringList = List.of("java", "c++", "python", "c#");
        List<String> expected = List.of("c#", "c++", "java", "python");

        assertEquals(expected, Utils.sortByLength(stringList));
    }

    @Test
    void allMatch() {
        List<String> stringList = List.of("java", "best", "lang");
        Predicate<String> condition = s -> s.length() == 4;

        assertTrue(Utils.allMatch(stringList, condition));

        stringList = List.of("java", "best", "lang", "python");
        condition = s -> s.length() < 5;

        assertFalse(Utils.allMatch(stringList, condition));
    }

    @Test
    void convertToLengths() {
        List<String> stringList = List.of("java", "c++", "python", "c#");
        List<Integer> expected = List.of(4, 3, 6, 2);

        assertEquals(expected, Utils.convertToLengths(stringList));
    }
}