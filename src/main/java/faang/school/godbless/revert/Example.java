package faang.school.godbless.revert;

public class Example {
    public void reverse(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
