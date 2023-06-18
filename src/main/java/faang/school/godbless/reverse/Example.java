package faang.school.godbless.reverse;

public class Example {
    public static int[] reverse(int[] nums) {
        int j = nums.length - 1;
        for (int i = 0; i < j; i++) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j--;
        }
        return nums;
    }
}
