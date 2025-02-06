package school.faang;

public class Example {
    public static int[] reverse(int[] nums) {
        int[] reverseNums = new int[nums.length];
        for (int i=0; i < nums.length; i++) {
            reverseNums[i] = nums[nums.length - 1 - i];
        }
        nums = reverseNums;
        return nums;
    }
}
