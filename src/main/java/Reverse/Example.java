package Reverse;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int last = nums[nums.length - (i + 1)];
            nums[nums.length - (i + 1)] = nums[i];
            nums[i] = last;
        }
        System.out.println(Arrays.toString(nums));
    }
}
