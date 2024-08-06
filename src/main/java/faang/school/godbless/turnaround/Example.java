package faang.school.godbless.turnaround;

import java.util.Arrays;

public class Example {

    public static void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left += 1;
            right -= 1;
        }
        System.out.println(Arrays.toString(nums));
    }
}