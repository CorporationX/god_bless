package faang.school.godbless.reverseTask;

public class Example {
    public static void reverse(int[] nums) {
        int temp;

        if (nums.length == 2) {
            temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;

            return;
        }

        for (int i = 0; i <= nums.length / 2; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = temp;
        }
    }
}
