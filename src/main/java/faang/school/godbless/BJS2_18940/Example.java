package faang.school.godbless.BJS2_18940;

public class Example {

    public static int[] reverse(int[] nums) {
        int[] reversed = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            reversed[nums.length - 1 - i] = nums[i];
        }

        return reversed;
    }
}
