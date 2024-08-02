import faang.school.godbless.BJS2_18802.Example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ReverseTest {
    @Test
    public void testReverse() {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] expected1 = {5, 4, 3, 2, 1};
        Example.reverse(array1);
        assertArrayEquals(expected1, array1);

        int[] array2 = {10, 20, 30, 40};
        int[] expected2 = {40, 30, 20, 10};
        Example.reverse(array2);
        assertArrayEquals(expected2, array2);

        int[] array3 = {1};
        int[] expected3 = {1};
        Example.reverse(array3);
        assertArrayEquals(expected3, array3);

        int[] array4 = {};
        int[] expected4 = {};
        Example.reverse(array4);
        assertArrayEquals(expected4, array4);
    }
}
