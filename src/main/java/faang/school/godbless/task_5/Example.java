package faang.school.godbless.task_5;

public class Example {
    public static void reverseInPlace(int[] nums) {
        if (nums == null) return;
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;

            left++;
            right--;
        }
    }

    public static int[] reverse(int[] nums) {
        if (nums == null) return null;
        int[] output = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            output[nums.length - i - 1] = nums[i];
        }
        return output;
    }

}
