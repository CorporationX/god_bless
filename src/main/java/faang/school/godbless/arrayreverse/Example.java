package faang.school.godbless.arrayreverse;

public class Example {

    public static void reverse(int[] nums) {
        int L = 0, R = nums.length - 1;
        while (L < R) {
            int temp = nums[L];
            nums[L] = nums[R];
            nums[R] = temp;
            L++;
            R--;
        }
    }
}
