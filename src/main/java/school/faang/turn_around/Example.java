package school.faang.turn_around;

public class Example {

    public int[] reverse(int[] nums) {

        int[] reversed = new int[nums.length];
        for (int i = nums.length - 1, k = 0; i >= 0; i--, k++) {
            reversed[k] = nums[i];
        }
        return reversed;
    }
}
