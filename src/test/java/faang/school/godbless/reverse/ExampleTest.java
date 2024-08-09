package faang.school.godbless.reverse;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {

    @Test
    @DisplayName("Null input")
    public void testReverseNullInput() {
        assertThrows(IllegalArgumentException.class, () -> Example.reverseArray(null));
    }

    @Test
    @DisplayName("Empty Input")
    public void testReverseEmptyInput() {
        int[] arr = {};
        int[] reversedArr = {};
        assertArrayEquals(reversedArr, Example.reverseArray(arr));
    }


    @Test
    @DisplayName("Odd length input")
    public void testReverseLengthOdd() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] reversedArr = {5, 4, 3, 2, 1};

        assertArrayEquals(reversedArr, Example.reverseArray(arr));
    }

    @Test
    @DisplayName("Even length input")
    public void testReverseLengthEven() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] reversedArr = {6, 5, 4, 3, 2, 1};
        assertArrayEquals(reversedArr, Example.reverseArray(arr));
    }
}
