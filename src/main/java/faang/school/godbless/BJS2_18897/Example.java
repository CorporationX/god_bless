package faang.school.godbless.BJS2_18897;

public class Example {
    public static int[] reverse(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[length - 1 - i];
            nums[length - 1 - i] = temp;
        }
        return nums;
    }
}
