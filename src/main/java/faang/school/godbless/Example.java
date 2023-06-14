package faang.school.godbless;

public class Example {
    public int[] reverse(int[] nums) {
        int[] revertNums = new int[nums.length];
        int j = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            revertNums[j] = nums[i];
            j++;
        }
        return revertNums;
    }
}
