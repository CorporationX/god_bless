package faang.school.godbless.reverse;

public class Example {

    public int[] reverse(int[] nums) {
        int[] resultArray = new int[nums.length];
        for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
            resultArray[j] = nums[i];
        }
        return resultArray;
    }
}
