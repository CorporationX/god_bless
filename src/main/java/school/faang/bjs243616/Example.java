package school.faang.bjs243616;

public class Example {
    public static void reverse(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            int last = nums.length - 1 - i;
            nums[i] = nums[last];
            nums[last] = tmp;
        }
    }
}
