package school.faang.task_43621;

public class Example {
    public void reverse(int[] nums) {
        if (nums != null && nums.length > 0) {
            int left = 0;
            int right = nums.length - 1;
            while (left < right) {
                int value = nums[left];
                nums[left] = nums[right];
                nums[right] = value;

                left++;
                right--;
            }
        }
    }
}
