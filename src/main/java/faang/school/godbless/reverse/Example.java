package faang.school.godbless.reverse;

public class Example {
    public static void reverse(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[length - i - 1];
            nums[length - i - 1] = temp;
        }
    }
}

