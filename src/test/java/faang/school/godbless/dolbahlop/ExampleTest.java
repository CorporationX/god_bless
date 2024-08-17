package faang.school.godbless.dolbahlop;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ExampleTest {
    @Test
    void reverse_shouldReverse() {
        //Arange
        int[] array = {1, 2, 3};
        int[] expected = {3, 2, 1};

        //Act

        Example.reverse(array);

        //Assert
        assertArrayEquals(expected, array);
    }

    @Test
    void reverse_ShouldHandleEmptyArray() {
        // Arrange
        int[] array = {};
        int[] expected = {};

        // Act
        Example.reverse(array);

        // Assert
        assertArrayEquals(expected, array);
    }

    @Test
    void swap_ShouldSwapElements() {
        // Arrange
        int[] array = {1, 2};

        // Act
        Example.swap(array, 0, 1);

        // Assert
        assertArrayEquals(new int[]{2, 1}, array);
    }

    @Test
    void reverseTwice_ShouldReturnOriginalArray() {
        // Arrange
        int[] array = {1, 2, 3, 4};
        int[] expected = {1, 2, 3, 4};

        // Act
        Example.reverse(array); // Reverse once
        Example.reverse(array); // Reverse again

        // Assert
        assertArrayEquals(expected, array);
    }
}
