package faang.school.godbless;

public class Example {
    public static void revers(int[] nums) {
        nums = new int[] {1, 2, 3, 4, 5};
        for (int i = 0; i < nums.length / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[nums.length - i - 1];
            nums[nums.length - i - 1] = tmp;
        }
    }
}
