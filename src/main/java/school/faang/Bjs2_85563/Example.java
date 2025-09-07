package school.faang.Bjs2_85563;

public class Example {
    public static void reverse(int[] nums) {
        if (nums == null && nums.length <= 1) {
            return;
        }
        int left = 0;
        int right = nums.length - 1;
        int memory;
        while (right > left) {
            memory = nums[left];
            nums[left] = nums[right];
            nums[right] = memory;
            left++;
            right--;

        }
    }

}

