package faang.school.godbless.BJS2_18802;

import java.util.Arrays;
import java.util.List;

public class Example {
    public static void reverse(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
}
