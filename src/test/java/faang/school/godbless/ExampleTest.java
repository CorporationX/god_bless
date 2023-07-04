package faang.school.godbless;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ExampleTest {
    @Test
    void testReverse() {
        Example tester = new Example();
        int[] nums = {1, 2, 3};
        tester.reverse(nums);
        assertArrayEquals(nums, new int[]{3, 2, 1});
    }
}