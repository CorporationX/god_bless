package faang.school.godbless.reverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    void reverseOdd() {
        int[] expected = new int[]{5, 4, 3, 2, 1};
        int[] initial = new int[]{1, 2, 3, 4, 5};
        assertArrayEquals(expected, Example.reverse(initial));
    }

    @Test
    void reverseEven() {
        int[] expected = new int[]{4, 3, 2, 1};
        int[] initial = new int[]{1, 2, 3, 4};
        assertArrayEquals(expected, Example.reverse(initial));
    }
}