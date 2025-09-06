package school.faang.Bjs2_85563;

public class Example {
    public int[] reverse(int[] nums) {
        int[] revereseNums = new int[nums.length];
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            revereseNums[length - (i + 1)] = nums[i];
        }
        return revereseNums;
    }
}
