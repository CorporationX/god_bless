package reverseArray;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(reverse(nums)));
    }

    public static int[] reverse(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length / 2; i++) {
            int num = nums[i];
            nums[i] = nums[length - 1 - i];
            nums[length - 1 - i] = num;
        }
        return nums;
    }
}
