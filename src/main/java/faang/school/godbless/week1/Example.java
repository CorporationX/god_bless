package faang.school.godbless.week1;

import java.util.Arrays;

public class Example {

    //Method reverse an array of integers

    public void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            //Swap the elements
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            //Move to middle
            left++;
            right--;
        }
    }
    //Testing method
    public static void main(String[] args){
        Example example = new Example();
        int[] nums = {1,2,3,4,5,6,7,8,9,0};
        System.out.println("Original Array; " + Arrays.toString(nums));

        example.reverse(nums);
        System.out.println("Revers Array : " + Arrays.toString(nums));
    }
}
