package faang.school.godbless.reverseTask;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] nums) {
        int[] temp = nums.clone();
        int pointer = 0;

        for(int i = nums.length - 1; i >= 0; i--) {
            nums[pointer] = temp[i];
            pointer++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        reverse(nums);

        Arrays.stream(nums).forEach(System.out::print);
    }
}
