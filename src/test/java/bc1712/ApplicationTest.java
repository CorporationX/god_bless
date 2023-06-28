package bc1712;

import LambdaStream.bc1712.Application;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApplicationTest {
    List<Integer> nums;
    List<String> strings;

    @BeforeEach
    void setUp() {
        nums = List.of(5, 8, 0, -10, 10);
        strings = List.of("Vasya", "Alex", "Olya", "Andrei", "Anna");
    }

    @Test
    void sum() {
        Assertions.assertEquals(13, Application.sum(nums));
    }

    @Test
    void max() {
        List<Integer> numsEmpty = List.of();
        assertEquals(10, Application.max(nums));
        assertThrows(NullPointerException.class, () -> Application.average(numsEmpty));
    }

    @Test
    void average() {
        List<Integer> numsEmpty = List.of();
        assertEquals(2.6, Application.average(nums));
        assertThrows(NullPointerException.class, () -> Application.average(numsEmpty));
    }

    @Test
    void countString() {
        assertEquals(3, Application.countString(strings));
    }

    @Test
    void containsString() {
        List<String> expected = List.of("Andrei", "Anna");
        assertEquals(expected, Application.containsString(strings));
    }

    @Test
    void lengthString() {
        List<String> expected = List.of("Alex", "Olya", "Anna", "Vasya", "Andrei");
        assertEquals(expected, Application.lengthString(strings));
    }

    @Test
    void allMatch() {
        assertTrue(Application.allMatch(strings, 3));
        assertFalse(Application.allMatch(strings, 5));
    }

    @Test
    void min() {
        List<Integer> numsEmpty = List.of();
        assertEquals(8, Application.min(nums, 5));
        assertThrows(NullPointerException.class, () -> Application.average(numsEmpty));
    }

    @Test
    void listLength() {
        List<Integer> expected = List.of(5, 4, 4, 6, 4);
        assertEquals(expected, Application.listLength(strings));
    }
}