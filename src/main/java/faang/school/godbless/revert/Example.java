package faang.school.godbless.revert;

public class Example {
    public static int[] reverse(int[] nums) {
        int[] reversedNums = new int[nums.length];
        for (int i = 0; i <= nums.length - 1; i++) {
            reversedNums[i] = nums[nums.length - 1 - i];
        }
        return reversedNums;
    }
}
