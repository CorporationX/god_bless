package module_1.module_1_1_JavaCore.school.faang;

public class Example {

    public static int[] reverse(int[] nums) {
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        return nums;
    }
}
