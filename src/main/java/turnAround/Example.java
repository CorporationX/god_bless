package turnAround;

public class Example {

    public void reverse(int[] nums) {

        int i = 0, j = nums.length - 1;
        while (i < j) {
            nums[i] = nums[j] + nums[i];
            nums[j] = nums[i] - nums[j];
            nums[i] = nums[i] - nums[j];

            i++;
            j--;
        }

    }

}
