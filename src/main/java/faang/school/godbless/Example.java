package faang.school.godbless;

import java.util.Objects;

public class Example {

    public int[] reverse(int[] nums) {
        Objects.requireNonNull(nums, "Array must not be null");
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int curr = nums[i];
            nums[i] = nums[j];
            nums[j] = curr;
        }
        return nums;
    }
}
