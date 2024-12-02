package school.faang.reverse;

import java.util.Arrays;

public class Example {

    public static void reverse(int[] nums) {
        if (nums == null || nums.length == 0) {
            System.out.println("Массив пуст");
        } else {
            for (int i = 0; i < nums.length / 2; i++) {
                int temp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = temp;
            }

            System.out.println("nums = "
                    + Arrays.toString(nums));
        }
    }
}
