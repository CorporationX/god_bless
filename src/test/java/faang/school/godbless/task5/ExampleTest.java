package faang.school.godbless.task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    void testReverse() {
        int[] array = new int[]{1, 2, 3, 4 ,5};

        int[] result = Example.reverse(array);

        int[] expected = new int[]{5, 4, 3, 2, 1,};

        assertArrayEquals(expected, result);
        assertThrows(IllegalArgumentException.class, () -> Example.reverse(new int[0]));
    }
}