package turnAround;

public class Example {

    public void reverse(int[] nums) {
        int j;
        for (int i = 0; i < nums.length / 2; i++) {
            j = nums.length - 1 - i;
            nums[i] = nums[j] + nums[i];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];
        }

    }

}
