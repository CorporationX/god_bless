package faang.school.godbless;

public class Example {
    public int[] reverse(int[] nums) {
        for (int i = 1; i <= nums.length / 2; i++) {
            int temp = nums[nums.length - i];
            nums[nums.length - i] = nums[i - 1];
            nums[i - 1] = temp;
        }
        return nums;
    }
}
