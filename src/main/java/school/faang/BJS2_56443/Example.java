package school.faang.BJS2_56443;

public class Example {
    public void reverse(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
