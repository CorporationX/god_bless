package school.faang.task_43599;

public class Example {

    public static void reverse(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp =  nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}

