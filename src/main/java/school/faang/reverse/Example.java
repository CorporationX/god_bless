package src.main.java.school.faang.reverse;

import java.util.Arrays;

public class Example {

    public static int[] reverse(int[] nums){

        int[] reversed = new int[nums.length];

        for (int i = 0; i < nums.length; i++ ){

            reversed[i] = nums[nums.length - 1 - i];
 
        }
        return reversed;

          
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] reversedNums = reverse(nums);
    
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(reversedNums));
    }
}
