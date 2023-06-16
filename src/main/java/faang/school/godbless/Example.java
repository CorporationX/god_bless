package faang.school.godbless;

public class Example {
    public static int[] reverse(int[] nums) {

        for (int i = 0; i < nums.length / 2; i++) {
            nums[i] += nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = nums[i] - nums[nums.length - 1 - i];
            nums[i] -= nums[nums.length - 1 - i];
        }
        return nums;
    }
}
