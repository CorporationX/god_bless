package school.faang.BJS2_43616;

public class Example {
    public static void reverse(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        int[] copy = nums.clone();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = copy[nums.length - 1 - i];
        }
    }
}
 