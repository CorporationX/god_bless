package school.faang.module1.array_reverse;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.faang.module1.array_reverse.Example;

class ExampleTest {

    private final Example example = new Example();

    @Test
    void testReverseArray() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expected = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        Assertions.assertArrayEquals(expected, example.reverse(array));
    }

    @Test
    void testReverseWhenArrayIsNull() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> example.reverse(null));
        Assertions.assertEquals("null array is illegal", exception.getMessage());
    }

    @Test
    void testReverseWhenArrayIsEmpty() {
        int[] emptyArr = new int[0];
        Assertions.assertEquals(emptyArr, example.reverse(emptyArr));
    }

    @Test
    void testReverseWhenArrayHasOneElement() {
        int[] arrOneElement = new int[1];
        arrOneElement[0] = 5;
        Assertions.assertEquals(arrOneElement, example.reverse(arrOneElement));
    }

}