package school.faang.sprint_1.task_bjs43626;


public class Example {
    public int[] reverse(int[] nums) {
        int[] newArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[i] = nums[nums.length - 1 - i];
        }
        return newArray;
    }
}
