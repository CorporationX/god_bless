package faang.school.godbless.reverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExampleTest {

    @Test
    public void testReverseInvalidArgument() {
        assertThrows(IllegalArgumentException.class, () -> Example.reverseArray(null));
    }

    @Test
    public void testReverseEmptyInput() {
        Double[] doubles = {};
        Double[] reversed = {};
        assertArrayEquals(reversed, Example.reverseArray(doubles));
    }

    @Test
    public void testReverseLengthOdd() {
        Integer[] ints = {1, 2, 3, 4, 5};
        Integer[] reversedInts = {5, 4, 3, 2, 1};

        assertArrayEquals(reversedInts, Example.reverseArray(ints));
    }

    @Test
    public void testReverseLengthEven() {
        Float[] floats = {1f, 2f, 3f, 4f, 5f, 6f};
        Float[] reversedFloats = {6f, 5f, 4f, 3f, 2f, 1f};
        assertArrayEquals(reversedFloats, Example.reverseArray(floats));
    }
}
