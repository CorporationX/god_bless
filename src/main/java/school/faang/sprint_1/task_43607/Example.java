package school.faang.sprint_1.task_43607;

public class Example {

    static void reverse(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }
    }
}

