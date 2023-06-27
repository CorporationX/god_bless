import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExampleTest {

    private Example example;

    @BeforeEach
    public void setUp() {
        example = new Example();
    }

    @Test
    public void testReverse() {
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};
        int[] result = example.reverse(originalArray);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testReverse1() {
        int[] originalArray = {1};
        int[] expected = {1};
        int[] result = example.reverse(originalArray);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testReverseEmptyArray() {
        int[] originalArray = {};
        int[] expected = {};
        int[] result = example.reverse(originalArray);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testReverseNull() {
        assertThrows(IllegalArgumentException.class, () -> {example.reverse(null);});
    }

}