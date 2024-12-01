package school.faang;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        reverse(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void reverse(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }
}