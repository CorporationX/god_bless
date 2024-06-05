package faang.school.godbless;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ExampleTest {

    @Test
    void reverse() {
        int[] expected = {5, 4, 3, 2, 1};

        int[] actual = Example.reverse(new int[]{1, 2, 3, 4, 5});

        Assertions.assertArrayEquals(actual, expected);
    }
}