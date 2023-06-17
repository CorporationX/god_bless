package faang.school.godbless;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ReverseTest {

    @Test
    public void testReverse() {

        Example reverser = new Example();

        int[] straightArray = {0, 1, 2, 3, 4, 5};
        int[] expectedArray = {5, 4, 3, 2, 1, 0};

        Assertions.assertArrayEquals(expectedArray, reverser.reverse(straightArray));
    }
}
