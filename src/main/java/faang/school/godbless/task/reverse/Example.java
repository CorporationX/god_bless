package faang.school.godbless.task.reverse;

public class Example {

    public int[] reverse(int[] nums) {
        int[] reverseNums = new int[nums.length];
        for(int i = 0, j = nums.length-1; i < nums.length; i++, j--) {
            reverseNums[j] = nums[i];
        }
        return reverseNums;
    }
}
