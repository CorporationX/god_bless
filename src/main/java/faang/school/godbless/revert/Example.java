package faang.school.godbless.revert;

public class Example {
    public int[] reverse(int[] nums) {
        int[] reversedNums = new int[nums.length];
        int currentIndex = 0;

        for (int i = nums.length - 1; i >=0; --i) {
            reversedNums[currentIndex] = nums[i];
            currentIndex++;
        }
        return reversedNums;
    }
}
