package faang.school.godbless.Reverse1983;

public class Example {

    public static int[] reverse(int[] nums) {
        int length = nums.length;
        int[] reversed = new int[length];
        for (int i = 0, j = length - 1; i < length && j >= 0; i++, j--) {
            reversed[i] = nums[j];
        }
        return reversed;
    }
}
