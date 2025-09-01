package school.faang.array_reverse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExampleTest {

    private final Example example = new Example();

    @Test
    void testReverseArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expected = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        Assertions.assertArrayEquals(expected, example.reverse(array));
    }

}