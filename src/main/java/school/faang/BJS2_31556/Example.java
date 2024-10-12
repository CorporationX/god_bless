package school.faang.BJS2_31556;

import java.util.Arrays;

public class Example {

    public void reverse(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }
    }

    public static void main(String[] args) {
        Example example = new Example();
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println("Before reverse: " + Arrays.toString(nums));
        example.reverse(nums);
        System.out.println("After reverse: " + Arrays.toString(nums));
    }

}
