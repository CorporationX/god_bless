package BJS2_4377;

public class Example {

    public static int[] reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int firstElement = nums[i];
            int lastElement = nums[(nums.length - 1) - i];
            nums[i] = lastElement;
            nums[(nums.length - 1) - i] = firstElement;
        }
        return nums;
    }
}
