package faang.school.godbless.Reverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ExampleTest {
    @Test
    void reverse_shouldReturnNull() {
        int[] expected = new int[]{};
        int[] num = null;

        int[] actual = Example.reverse(num);

        assertArrayEquals(expected, actual);
    }

    @Test
    void reverse_shouldReverse() {
        int[] num = new int[]{1, 2, 3, 4, 5, 6};
        int[] expected = new int[]{6, 5, 4, 3, 2, 1};

        int[] actual = Example.reverse(num);

        assertArrayEquals(expected, actual);
    }
}
