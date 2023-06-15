package faang.school.godbless.turn_around_BC_408;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleTest {
    @Test
    public void shouldReturnReverseArray() {
        int[] originalArray = {1, 2, 3, 4, 5};
        int[] expectedArray;
        expectedArray = new int[]{5, 4, 3, 2, 1};
        Assertions.assertArrayEquals(expectedArray, Example.reverse(originalArray));
    }
}