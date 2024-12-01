package school.faang;

import java.util.Arrays;


public class Example {
    public static void main(String[] args) {

        int[] nums = {};

        System.out.println("Old nums is: " + Arrays.toString(nums));
        reverse(nums);
        System.out.println("Reverse nums is: " + Arrays.toString(nums));

    }


    public static void reverse(int[] nums) {

        if (nums.length == 0) {
            System.out.println("Empty array");
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        int temp;

        while (left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}





