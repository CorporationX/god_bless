package school.faang.BJS2_31432;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExampleTest {
    @Test
    @DisplayName("Testing reverse method with valid array")
    void testExample_ReverseValidArray() {
        //arrange
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int[] expectedNumbers = {6, 5, 4, 3, 2, 1};

        //act
        Example.reverse(numbers);

        //assert
        assertArrayEquals(expectedNumbers, numbers);
    }

    @Test
    @DisplayName("Testing reverse method with null array")
    void testExample_ReverseNullArray() {
        //act + assert
        IllegalArgumentException argumentException = assertThrows(IllegalArgumentException.class,
                () -> Example.reverse(null));
        assertEquals("Invalid array.", argumentException.getMessage());
    }

    @Test
    @DisplayName("Testing reverse method with empty array")
    void testExample_ReverseEmptyArray() {
        //arrange
        int[] numbers = {};
        int[] expectedNumbers = {};

        //act
        Example.reverse(numbers);

        //assert
        assertArrayEquals(expectedNumbers, numbers);
    }

    @Test
    @DisplayName("Testing reverse method with single element array")
    void testExample_ReverseSingleElementArray() {
        //arrange
        int[] numbers = {1};
        int[] expectedNumbers = {1};

        //act
        Example.reverse(numbers);

        //assert
        assertArrayEquals(expectedNumbers, numbers);
    }
}