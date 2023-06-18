package faang.school.godbless.reverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    void reverseTest() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};

        int[] actual = Example.reverse(nums);

        assertArrayEquals(expected, actual);
    }
}