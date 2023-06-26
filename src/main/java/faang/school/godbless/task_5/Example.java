package faang.school.godbless.task_5;

import java.util.ArrayList;

public class Example {
    public static void reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int head = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = head;
        }
    }
}
