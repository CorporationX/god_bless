package faang.school.godbless.java_core.turn_around;

public class Example {
    static void reverse(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        int temp;
        for (int i = 0; i < nums.length / 2; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }
}
