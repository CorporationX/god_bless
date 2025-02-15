package school.faang;

public class Example {
    public static int[] reverse(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int middleIndex = nums.length / 2;
        for (int leftIndex = 0, rightIndex = nums.length - 1; leftIndex < middleIndex; leftIndex++, rightIndex--) {
            int leftIndexValue = nums[leftIndex];
            nums[leftIndex] = nums[rightIndex];
            nums[rightIndex] = leftIndexValue;
        }

        return nums;
    }
}
