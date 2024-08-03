package faang.school.godbless.reverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    void reverse() {
        int[] nums = {1,-2,3,-4,5};
        int[] reverseNums = {5,-4,3,-2,1};

        int[] result = Example.reverse(nums);

        assertArrayEquals(reverseNums, result);
    }

    @Test
    void reverse_OneNum() {
        int[] nums = {Integer.MAX_VALUE};
        int[] reverseNums = {Integer.MAX_VALUE};

        int[] result = Example.reverse(nums);

        assertArrayEquals(reverseNums, result);
    }

    @Test
    void reverse_EmptyArray() {
        int[] nums = new int[5];
        int[] reverseNums = new int[5];

        int[] result = Example.reverse(nums);

        assertArrayEquals(reverseNums, result);
    }

    @Test
    void reverse_ArrayLengthZero() {
        int[] nums = new int[0];
        int[] reverseNums = new int[0];

        int[] result = Example.reverse(nums);

        assertArrayEquals(reverseNums, result);
    }
}