package faang.school.godbless.turn;


public class Example {

    public static void reverse(int[] nums) {
        for (int j = 0; j < nums.length / 2; j++) {
            int temp = nums[j];
            nums[j] = nums[nums.length - j - 1];
            nums[nums.length - j - 1] = temp;
        }
    }
}
