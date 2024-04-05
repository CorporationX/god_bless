package reverseArray;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(reverse(nums)));
    }

    public static int[] reverse(int[] nums) {
        int[] numsReverse = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsReverse[i] = nums[nums.length - i - 1];
        }
        return numsReverse;
    }
}
