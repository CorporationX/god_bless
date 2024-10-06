package tasks.bjs2_31449;

public class Example {
    public static int[] reverse(int[] nums) {
        int[] reverseNums = new int[nums.length];

        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            reverseNums[i] = nums[nums.length - 1 - i];
            reverseNums[nums.length - 1 - i] = temp;
        }

        return reverseNums;
    }
}
