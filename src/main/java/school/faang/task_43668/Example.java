package school.faang.task_43668;

public class Example {
    public static void reverse(int[] nums) {
        for (var i = 0; i < nums.length / 2; i++) {
            var num = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = num;
        }
    }
}
