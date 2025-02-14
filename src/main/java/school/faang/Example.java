package school.faang;

public class Example {
    public static int[] reverse(int[] nums) {
        int[] result = new int[nums.length];

        if (result.length == 0) {
            return result;
        }

        int middleIndex = nums.length >> 1;
        for (int leftIndex = 0; leftIndex <= middleIndex; leftIndex++) {
            int rightIndex = nums.length - 1 - leftIndex;

            result[leftIndex] = nums[rightIndex];
            result[rightIndex] = nums[leftIndex];
        }

        if (nums.length % 2 != 0) {
            result[middleIndex + 1] = nums[middleIndex + 1];
        }

        return result;
    }
}
