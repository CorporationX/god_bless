package faang.school.godbless;

public class Example {

    public static int[] reverse(int[] nums) {
        int[] reverseNums = new int[nums.length];
        for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
            reverseNums[j] = nums[i];
        }
        return reverseNums;
    }
}
