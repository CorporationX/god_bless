package faang.school.godbless.BJS218870;


import java.util.Arrays;

public class Example {
    public static void reverse(int[] nums){
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        Example.reverse(nums);
        System.out.println(Arrays.toString(nums));
    }
}
