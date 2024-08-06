package faang.school.godbless.reverse;

public class Example {
    public static int[] reverse(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length / 2; i++) {
            int t = nums[i];
            nums[i] = nums[length - 1 - i];
            nums[length - 1 - i] = t;
        }
        return nums;
    }
}
