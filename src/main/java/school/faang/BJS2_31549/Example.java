package school.faang.BJS2_31549;

import java.util.Arrays;
import java.util.Random;

public class Example {
    public static void main(String[] args) {

        int[] nums = new int[15];
        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }

        System.out.println(Arrays.toString(nums));
        nums = reverse(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] reverse(int[] nums) {

        if (nums == null || nums.length == 0){
            return nums;
        }

        int num;
        int middle = nums.length/2;
        for(int i = 0; i < middle; i++) {
            num = nums[i];
            nums[i] = nums[nums.length - i - 1] ;
            nums[nums.length - i - 1] = num;
        }
        return nums;
    }
}
