package school.faang.bjs279257;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExampleTest {
    @Test
    void reverseNormalArrayShouldReturnReversed() {
        int[] input = { 1, 2, 3, 4, 5 };
        int[] expected = { 5, 4, 3, 2, 1 };
        Example.reverse(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void reverseEmptyArrayShouldReturnEmpty() {
        int[] input = {};
        int[] expected = {};
        Example.reverse(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void reverseSingleElementArrayShouldReturnSame() {
        int[] input = { 42 };
        int[] expected = { 42 };
        Example.reverse(input);
        assertArrayEquals(expected, input);
    }

    @Test
    void reverseNullArrayShouldThrowException() {
        assertThrows(NullPointerException.class, () -> Example.reverse(null));
    }
}
