package school.faang.task_56380;


public class Example {
    public static int[] reverse(int[] nums) {
        int startNum = 0;
        int endNum = nums.length - 1;
        for (int i = 0; i < nums.length / 2; i++) {
            startNum = nums[i];
            nums[i] = nums[endNum];
            nums[endNum] = startNum;
            endNum--;
        }
        return nums;
    }
}
