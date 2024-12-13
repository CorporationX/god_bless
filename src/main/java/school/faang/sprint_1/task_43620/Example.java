package school.faang.sprint_1.task_43620;

public class Example {
    public static void reverse(int[] nums) {
        int leftNums = 0;
        int rightNums = nums.length - 1;
        while (leftNums < rightNums) {
            int temp = nums[leftNums];
            nums[leftNums] = nums[rightNums];
            nums[rightNums] = temp;
            leftNums++;
            rightNums--;
        }
    }
}
