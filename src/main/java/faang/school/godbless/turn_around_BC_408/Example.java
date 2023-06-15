package faang.school.godbless.turn_around_BC_408;

import java.lang.reflect.Array;

public class Example {

    public static int[] reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }
}
