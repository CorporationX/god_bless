package school.faang.bjs2_79197;

public class Example {
    public static void reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        for (int i : nums) {
            System.out.printf("%d ", i);
        }
    }
}
