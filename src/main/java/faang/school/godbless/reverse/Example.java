package faang.school.godbless.reverse;

import java.util.Objects;

class Example {
    public int[] reverse(int[] nums) {
        if (Objects.nonNull(nums)) {
            int size = nums.length;
            for (int i = 0; i < size / 2; i++) {
                int tmp = nums[i];
                nums[i] = nums[size - 1 - i];
                nums[size - 1 - i] = tmp;
            }
            return nums;
        }
        return new int[0];
    }
}
