package faang.school.godbless;

import java.util.Arrays;
import java.util.Collections;

public class Example {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        reverse(nums);
    }
    public static void reverse(int[] nums) {
        int size = nums.length;
        int temp;
        for (int i = 0; i < size / 2; i++) {
            temp = nums[i];
            nums[i] = nums[(size-1) - i];
            nums[(size - 1) - i] = temp;
        }
        System.out.println(Arrays.toString(nums));
     }
}
