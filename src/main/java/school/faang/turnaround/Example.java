package school.faang.turnaround;

public class Example {
    public int[] reverse(int[] nums) {
        int right = nums.length - 1;
        int left = 0;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        return nums;
    }
}

