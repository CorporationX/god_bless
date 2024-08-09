package faang.school.godbless.javacore.turnaround;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ExampleTest {

    @Test
    void testReverse() {
        int[] nums = {1, 2, 3, 4, 5};

        Example.reverse(nums);

        assertArrayEquals(new int[]{5, 4, 3, 2, 1}, nums);
    }

    @Test
    void testReverseOnlyOneNumber() {
        int[] nums = {1};

        Example.reverse(nums);

        assertArrayEquals(new int[]{1}, nums);
    }

    @Test
    void testReverseEmptyInput() {
        int[] nums = {};

        Example.reverse(nums);

        assertArrayEquals(new int[]{}, nums);
    }
}