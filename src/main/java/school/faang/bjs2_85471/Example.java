package school.faang.bjs2_85471;

import java.util.Arrays;

public class Example {

    public int[] reverse(int[] nums) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
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

    public static void main(String[] args) {
        Example example = new Example();
        int[] nums = {1, 2, 3, 4, 5};

        System.out.println(Arrays.toString(nums));

        example.reverse(nums);

        System.out.println(Arrays.toString(nums));
    }
}

   
