package faang.school.godbless.turn_around;

public class Example {
    public int[] reverse(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[n - 1 - i];
            nums[n - 1 - i] = temp;
        }
        return nums;
    }
}
