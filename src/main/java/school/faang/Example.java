package school.faang;

public class Example {

    public static void reverse(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums.length - i;
        }
    }
}