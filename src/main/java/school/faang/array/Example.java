package school.faang.array;

import java.util.Arrays;

public class Example {


    public  int[] reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int result = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = result;
        }

        return nums;


    }
}
