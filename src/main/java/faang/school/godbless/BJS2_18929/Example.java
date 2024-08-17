package faang.school.godbless.BJS2_18929;

public class Example {
        public int[] reverse(int[] nums) {
            int[] reversed = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                reversed[i] = nums[nums.length - 1 - i];
            }
            return reversed;
        }
}
