package faang.school.godbless.Reverse1983;

public class Example {

    public int[] reverse(int[] nums) {
        int length = nums.length;
        int[] reversed = new int[length];
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                reversed[i] = nums[j];
            }
        }
        return reversed;
    }
}
