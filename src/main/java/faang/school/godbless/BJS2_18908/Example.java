package faang.school.godbless.BJS2_18908;

public class Example {

    public static int[] reverse(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left++] = nums[right];
            nums[right--] = temp;
        }

        return nums;
    }
}
