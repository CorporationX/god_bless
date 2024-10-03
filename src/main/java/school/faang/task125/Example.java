package school.faang.task125;

import java.util.Arrays;

public class Example {
    public static int[] reverse(int [] nums){

        int step=nums.length-1;
        for (int i = 0; i <nums.length/2 ; i++) {
            int bubble=nums[i];
            nums[i]=nums[step];
            nums[step]=bubble;
            step--;
        }
        return nums;
    }

}
