package school.faang;

import java.util.Arrays;

public class Example {
    public void reverse(int[] nums) {

        int[] reversed = new int[nums.length];
        for (int i = 0; i < nums.length / 2; i++) {
            reversed[i] = nums[nums.length - i - 1];
            reversed[nums.length - i - 1] = nums[i];
        }
        System.out.println(Arrays.toString(reversed));
    }
}
