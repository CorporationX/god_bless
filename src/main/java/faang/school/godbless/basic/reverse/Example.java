package faang.school.godbless.basic.reverse;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] nums) {
        System.out.println("Initial nums: " + Arrays.toString(nums));
        int count = nums.length - 1;
        for (int i = 0 ;  i < nums.length; i++) {
            int tmp = nums[count];
            if (count == i) break;
            nums[count] = nums[i];
            nums[i] = tmp;
            count--;
        }
        System.out.println("Reversed nums: " + Arrays.toString(nums));
    }
}
