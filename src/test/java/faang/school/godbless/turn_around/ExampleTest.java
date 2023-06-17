package faang.school.godbless.turn_around;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ExampleTest {

    @Test
    public void testReverse() {
        int[] nums = {5, 4, 9, 7, 1};
        int[] expected = {1, 7, 9, 4, 5};

        Example.reverse(nums);

        assertArrayEquals(expected, nums);
    }
}