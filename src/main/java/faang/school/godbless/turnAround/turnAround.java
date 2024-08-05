package faang.school.godbless.turnAround;

public class turnAround {
    public void reverse(int[] nums) {
        if (nums.length > 1) {
            int left = 0;
            int right = nums.length - 1;

            while (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;

                left++;
                right--;
            }
        }
    }
}
