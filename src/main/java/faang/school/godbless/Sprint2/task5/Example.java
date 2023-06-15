package faang.school.godbless.Sprint2.task5;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] nums){
        for(int i=0; i<nums.length/2; i++){
            int temp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }
}
