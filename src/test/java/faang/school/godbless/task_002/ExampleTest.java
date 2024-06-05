package faang.school.godbless.task_002;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ExampleTest {
    @Test
    void testReverseNull() {
        // Arrange
        int[] actual = null;

        // Act
        Example.revers(actual);

        // Assert
        assertNull(actual, "should have been null");
    }

    @Test
    void testReverseSingleElement() {
        // Arrange
        int[] actual = new int[]{1};
        int[] expectation = new int[]{1};

        // Act
        Example.revers(actual);

        // Assert
        assertArrayEquals(expectation, actual, "should have been: " + Arrays.toString(expectation));
    }

    @Test
    void testReverseEvenNumberElements() {
        // Arrange
        int[] actual = new int[]{1, 2, 3, 4};
        int[] expectation = new int[]{4, 3, 2, 1};

        // Act
        Example.revers(actual);

        // Assert
        assertArrayEquals(expectation, actual, "should have been: " + Arrays.toString(expectation));
    }

    @Test
    void testReverseNotEvenNumberElements() {
        // Arrange
        int[] actual = new int[]{1, 2, 3, 4, 5};
        int[] expectation = new int[]{5, 4, 3, 2, 1};

        // Act
        Example.revers(actual);

        // Assert
        assertArrayEquals(expectation, actual, "should have been: " + Arrays.toString(expectation));
    }
}
