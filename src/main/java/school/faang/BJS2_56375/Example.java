package school.faang.BJS2_56375;

public class Example {
    public int[] reverse(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        int rev;
        for (int i = 0; i < nums.length / 2; i++) {
            rev = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = rev;
        }
        return nums;
    }
}
