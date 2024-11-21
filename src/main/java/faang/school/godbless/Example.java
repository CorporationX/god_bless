package faang.school.godbless;

import java.util.Optional;

public class Example {
    private int need = -1;
    public int[] reverse(int[] nums){
        for (int i = nums.length-1; i > (nums.length/2) - 1; i--){
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        return nums;
    }

    public static void main(String args[]){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Example out = new Example();
        out.reverse(nums);
        for(int i = 0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
