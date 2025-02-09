package school.faang.task_56380;


public class Example {
    public static int[] reverse(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        for (int i = 0; i < nums.length / 2; i++) {
            leftPointer = nums[i];
            nums[i] = nums[rightPointer];
            nums[rightPointer] = leftPointer;
            rightPointer--;
        }
        return nums;
    }
}
