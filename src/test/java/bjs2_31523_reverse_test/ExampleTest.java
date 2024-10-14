package bjs2_31523_reverse_test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.faang.m1s1.bjs2_31523_Reverse.Example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ExampleTest {

    @Test
    @DisplayName("Odd number of integers in an array")
    void testOddArrayLengthReverse() {
        Example example = new Example();

        int[] array = {1, 2, 3, 4, 5};

        example.reverse(array);

        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, array);
    }

    @Test
    @DisplayName("Even number of integers in an array")
    void testEvenArrayLengthReverse() {
        Example example = new Example();

        int[] array = {1, 2, 3, 4, 5, 6};

        example.reverse(array);

        assertArrayEquals(new int[]{6, 5, 4, 3, 2, 1}, array);
    }

    @Test
    @DisplayName("Even number of integers in an array")
    void testEmptyArrayReverse() {
        Example example = new Example();

        int[] array = {};

        example.reverse(array);

        assertArrayEquals(new int[]{}, array);
    }
}
