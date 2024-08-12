package faang.school.godbless.bjs219002;

public class Example {
    public static void reverse(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int temp;

        while (left < right) {
            temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
