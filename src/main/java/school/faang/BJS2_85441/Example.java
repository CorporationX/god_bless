package school.faang.BJS2_85441;

public class Example {
    public void reverse(int[] nums) {
        if (nums == null) {
            throw new NullPointerException("nums is null");
        }

        if (nums.length <= 1) {
            return; //Nothing to reverse
        }

        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
