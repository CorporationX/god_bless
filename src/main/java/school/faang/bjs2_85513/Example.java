package school.faang.bjs2_85513;

public class Example {

    static int[] reverse(int[] nums) {
        int[] newNums = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            newNums[i] = nums[nums.length - 1 - i];
        }

        return newNums;
    }
}
