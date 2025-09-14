package school.faang.module1.reverse;

import java.util.Arrays;

public class Example {

    public static void reverse(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] num = {5, 4, 3, 2, 1};
        Example.reverse(num);
        System.out.println(Arrays.toString(num));
    }
}