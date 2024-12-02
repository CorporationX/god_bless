package school.faang.sprint_1.task_bjs2_43629;

public class Example {

    public int[] reverse(int[] nums) {
        int middleIndex = nums.length / 2;
        int lastIndex = nums.length - 1;
        for (int i = 0; i < middleIndex; i++) {
            int tmp = nums[i];
            nums[i] = nums[lastIndex - i];
            nums[lastIndex - i] = tmp;
        }

        return nums;
    }
}
