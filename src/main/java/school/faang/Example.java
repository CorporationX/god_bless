package school.faang;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        reverse(nums);
        System.out.println(Arrays.toString(nums));
    }
}

