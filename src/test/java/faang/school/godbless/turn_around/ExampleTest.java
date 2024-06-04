package faang.school.godbless.turn_around;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ExampleTest {

    @Test
    public void reverseTestOneToNine() {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Example.reverse(nums);
        assertArrayEquals(nums, new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1});
    }
    @Test
    public void reverseTestOne() {
        int[] nums = { 1 };
        Example.reverse(nums);
        assertArrayEquals(nums, new int[]{1});
    }

    @Test
    public void reverseTestEmpty() {
        int[] nums = {};
        Example.reverse(nums);
        assertArrayEquals(nums, new int[]{});
    }

    @Test
    public void reverseTestTwo() {
        int[] nums = { 2, 1};
        Example.reverse(nums);
        assertArrayEquals(nums, new int[]{1, 2});
    }
}