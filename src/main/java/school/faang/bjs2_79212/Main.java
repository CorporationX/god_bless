package school.faang.bjs2_79212;

import java.util.Arrays;

public class Main {
    public static void reverse(int[] nums) {
        if (nums == null) {
            return;
        }

        int j = nums.length - 1;
        for (int i = 0; i < j; i++) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            j--;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5};
        reverse(nums);
        System.out.println(Arrays.toString(nums));

        int[] nums1 = new int[]{1, 2, 4, 5};
        reverse(nums1);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = null;
        reverse(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
