package school.faang;

public class Example {
    public static void revers(int[] nums) {
        int temp;
        for (int i = 0; i < nums.length / 2; i++) {
            temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i ] = temp;
        }
    }
}
