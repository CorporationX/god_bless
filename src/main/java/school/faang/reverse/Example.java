package school.faang.reverse;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int n = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = n;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println("Initial Array: " + Arrays.toString(nums));
        reverse(nums);
        System.out.println("Reversed Array: " + Arrays.toString(nums));
    }
}
