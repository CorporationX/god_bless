package school.faang.task_43629;

public class Example {

    public int[] reverse(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Nums cannot be null or empty");
        }

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
