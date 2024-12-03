package school.faang.sprint_1.task_43624;

public class Example {
    public static void reverse(int[] nums) {
        int n = nums.length / 2;
        int d = nums.length - 1;
        for (int i = 0, j = d; i < n; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
