package school.faang.service;

public class Example {
    public static int[] reverse(int[] nums) {
        int[] reverseNum = new int[nums.length];
        int i = reverseNum.length - 1;
        for (int value : nums) {
            reverseNum[i] = value;
            i--;
            if (i < 0) break;
        }
        return reverseNum;
    }
}
