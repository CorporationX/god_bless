package faang.school.godbless.expand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


class ExampleTest {
    @Test
    void reverseEvenTest() {
        int[] array = {1, 2, 3, 4};
        int[] expected = {4, 3, 2, 1};

        int[] result = Example.reverse(array);

        assertArrayEquals(expected, result);
    }

    @Test
    void reverseOddTest() {
        int[] array = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};

        int[] result = Example.reverse(array);

        assertArrayEquals(expected, result);
    }
}