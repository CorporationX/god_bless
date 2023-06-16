package faang.school.godbless.TurnAround;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExampleTest {

    //Positive
    @Test
    @DisplayName("Reverse Test with even array length")
    public void revertTestEvenArray() {
        int[] expected = new int[]{1, 3, 5, 7};
        Assertions.assertArrayEquals(expected, Example.reverse(new int[]{7,5,3,1}));
    }

    @Test
    @DisplayName("Reverse Test with odd array length")
    public void revertTestOddArray() {
        int[] expected = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(expected, Example.reverse(new int[]{5, 4, 3, 2, 1}));
    }

    @Test
    @DisplayName("Reverse one element")
    public void reverseOneElementTest() {
        Assertions.assertArrayEquals(new int[]{1}, Example.reverse(new int[]{1}));
    }

    //Negative
    @Test
    @DisplayName("Reverse empty array")
    public void reverseEmptyArray() {
        int[] array = new int[]{};
        Assertions.assertArrayEquals(array, Example.reverse(array));
    }

    @Test
    @DisplayName("Try reverse null")
    public void reverseNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Example.reverse(null);
        });
    }
}
