package faang.school.godbless.task.reverse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ExampleTest {
    private int[] expected;
    private int[] actual;
    private Example example;

    int[] arr = new int[] {1, 2, 3, 4, 5};
    int[] arrRev = new int[] {5, 4, 3, 2, 1};

    @BeforeEach
    void setUp() {
        example = new Example();
    }

    @Test
    void testReverse() {
        expected = arrRev;
        actual = example.reverse(arr);
        assertArrayEquals(expected, actual);
    }

    @Test
    void testReverseZero() {
        expected = new int[0];
        actual = example.reverse(new int[0]);
        assertArrayEquals(expected, actual);
    }
}
