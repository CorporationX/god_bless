package school.faang.BJS2_28998;

import java.util.Arrays;
import java.util.Random;

public class Example {
    public static void main(String[] args) {

        int[] nums = new int[11];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(nums));

        nums = reverse(nums);

        System.out.println(Arrays.toString(nums));


    }
    public static int[] reverse(int[] nums) {

        if(nums == null || nums.length == 0)
            return nums;

        int[] reversed = new int[nums.length];
        int j = nums.length - 1;

        for(int i =0; i < nums.length; i++) {
            reversed[j] = nums[i];
            j--;
        }
        return reversed;
    }
}
