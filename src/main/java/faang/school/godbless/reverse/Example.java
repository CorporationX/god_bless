package faang.school.godbless.reverse;

import java.util.Arrays;

public class Example {
    public static void reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            swap(nums, i, nums.length - 1 - i);
        }
    }

    public static void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[][] arrays = new int[][]{{1, 2, 3, 4, 5}, {1, 2, 3, 4}, {1, 2, 3}, {1, 2}, {1}, {}};
        for (int[] nums : arrays) {
            reverse(nums);
            System.out.println(Arrays.toString(nums));
        }
    }
}
