package faang.school.godbless.turnAround_Task_5;

public class Example {
    public int[] reverse(int[] nums) {
        int numsSize = nums.length;
        int[] reverseNums = new int[numsSize];
        for(int i = 0; i < numsSize; i++) reverseNums[i] = nums[numsSize-1-i];
        return reverseNums;
    }
    public int[] reverse2(int[] nums) {
        int p1 = 0;
        int p2 = nums.length - 1;
        int[] reverseNums = new int[nums.length];
        while(p1 < p2) { reverseNums[p1++] = nums[p2--];}
        return reverseNums;
    }
}
