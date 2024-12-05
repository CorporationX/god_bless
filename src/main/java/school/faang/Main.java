package school.faang;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(reverse(nums)));
    }

    public static int[] reverse(int[] nums) {
        int i = 0;
        for (int j = nums.length-1; j >= nums.length/2; j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[nums.length-1-i] = temp;
            i++;
        }
        return nums;
    }
}
