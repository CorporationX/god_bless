package school.faang;

public class Example {
    public int[] reverse(int[] nums) {

        int[] reversed = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            reversed[i] = nums[nums.length - i - 1];
        }

        return reversed;
    }
}
