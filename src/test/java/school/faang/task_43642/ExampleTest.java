package school.faang.task_43642;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    void testSuccessReverse() {
        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, Example.reverse(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new int[]{}, Example.reverse(new int[]{}));
        assertArrayEquals(new int[]{5}, Example.reverse(new int[]{5}));
        assertArrayEquals(new int[]{4, 7}, Example.reverse(new int[]{7, 4}));
        assertArrayEquals(new int[]{1, 1}, Example.reverse(new int[]{1, 1}));
    }

    @Test
    void testReverseThrowException() {
        assertThrows(IllegalArgumentException.class, () -> Example.reverse(null));
    }
}