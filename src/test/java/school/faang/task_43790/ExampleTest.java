package school.faang.task_43790;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ExampleTest {

    @Test
    @DisplayName("reverse: should reverse an array with even number of elements")
    void reverse_shouldReverseEvenLengthArray() {
        // Arrange
        int[] numbers = {2, 4, 6, 8};

        // Act
        Example.reverse(numbers);

        // Assert
        assertAll("Verify array reversal",
                () -> assertArrayEquals(new int[]{8, 6, 4, 2}, numbers, "Array should be reversed")
        );
    }

    @Test
    @DisplayName("reverse: should reverse an array with odd number of elements")
    void reverse_shouldReverseOddLengthArray() {
        // Arrange
        int[] numbers = {1, 3, 5, 7, 9};

        // Act
        Example.reverse(numbers);

        // Assert
        assertAll("Verify array reversal",
                () -> assertArrayEquals(new int[]{9, 7, 5, 3, 1}, numbers, "Array should be reversed")
        );
    }

    @Test
    @DisplayName("reverse: should handle a single-element array")
    void reverse_shouldHandleSingleElementArray() {
        // Arrange
        int[] numbers = {42};

        // Act
        Example.reverse(numbers);

        // Assert
        assertAll("Verify single-element array remains unchanged",
                () -> assertArrayEquals(new int[]{42}, numbers, "Single-element array should remain the same")
        );
    }

    @Test
    @DisplayName("reverse: should handle an empty array")
    void reverse_shouldHandleEmptyArray() {
        // Arrange
        int[] numbers = {};

        // Act
        Example.reverse(numbers);

        // Assert
        assertAll("Verify empty array remains unchanged",
                () -> assertArrayEquals(new int[]{}, numbers, "Empty array should remain unchanged")
        );
    }

    @Test
    @DisplayName("reverse: should reverse an already reversed array")
    void reverse_shouldReverseAlreadyReversedArray() {
        // Arrange
        int[] numbers = {5, 4, 3, 2, 1};

        // Act
        Example.reverse(numbers);

        // Assert
        assertAll("Verify array reversal",
                () -> assertArrayEquals(new int[]{1, 2, 3, 4, 5}, numbers, "Array should be reversed back")
        );
    }

    @Test
    @DisplayName("reverse: should reverse an array with duplicate elements")
    void reverse_shouldReverseArrayWithDuplicateElements() {
        // Arrange
        int[] numbers = {1, 2, 2, 1};

        // Act
        Example.reverse(numbers);

        // Assert
        assertAll("Verify array with duplicates is reversed",
                () -> assertArrayEquals(new int[]{1, 2, 2, 1}, numbers, "Array should be reversed correctly")
        );
    }
}