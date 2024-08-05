package faang.school.godbless.basic.reverse;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] nums) {
        int[] reverseNums = new int[nums.length];
        int cnt = 0;
        for (int i = nums.length - 1 ;  i >= 0; i--) {
            reverseNums[cnt] = nums[i];
            cnt++;
        }
        System.out.println("Initial nums: " + Arrays.toString(nums));
        System.out.println("Reversed nums: " + Arrays.toString(reverseNums));
    }
}
