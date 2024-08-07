package reverse.test;

import reverse.Example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExampleTest {
    @Test
    @DisplayName("Testing reverse method with array odd length")
    void exampleTest_testingReverseWithOddArray() {
        int[] expected = {5, 4, 3, 2, 1};
        int[] result = {1, 2, 3, 4, 5};

        Example.reverse(result);

        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Testing reverse method with array even length")
    void exampleTest_testingReverseWithEvenArray() {
        int[] expected = {4, 3, 2, 1};
        int[] result = {1, 2, 3, 4};

        Example.reverse(result);

        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Testing reverse method with array of single element")
    void exampleTest_testingReverseSingleElementArray() {
        int[] expected = {1};
        int[] result = {1};

        Example.reverse(result);

        assertArrayEquals(expected, result);
    }

    @Test
    @DisplayName("Testing reverse method with null array")
    void exampleTest_testingReverseWithNullArray() {
        int[] array = null;

        NullPointerException ex = assertThrows(NullPointerException.class, () -> Example.reverse(array));
        assertEquals("Array is null!", ex.getMessage());
    }
}
