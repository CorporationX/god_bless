package school.faang.task_43665;

import java.util.Arrays;

public class Example {
    public static void main(String[] args) {
        int[] reverse = reverse(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(reverse));

        int[] reverseSecond = reverseInPlace(new int[]{1, 2, 3, 4, 5});
        System.out.println(Arrays.toString(reverseSecond));
    }

    public static int[] reverse(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums.length - 1 - i];
        }

        return result;
    }

    public static int[] reverseInPlace(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        return nums;
    }
}
