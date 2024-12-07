package school.faang.task_43665;

public class Example {

    public static int[] reverse(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array doesn't exist or empty");
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
        return nums;
    }
}
