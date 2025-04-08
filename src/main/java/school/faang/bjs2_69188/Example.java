package school.faang.bjs2_69188;

public class Example {
    public static int[] reverse(int[] nums) {
        if (nums != null && nums.length >= 1) {
            for (int i = 0; i < nums.length / 2; i++) {
                int j = nums[i];
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = j;
            }
        }

        return nums;
    }
}
