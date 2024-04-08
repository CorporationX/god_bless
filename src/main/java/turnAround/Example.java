package turnAround;

public class Example {

    public void reverse(int[] nums) {

        int i = 0, j = nums.length - 1, temp;

        while (i < j) {
            temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }

    }

}
