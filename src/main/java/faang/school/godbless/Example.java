package faang.school.godbless;

import lombok.Data;

@Data
public class Example {

    public int[] reverse(int[] nums) {

        int temp;
        int lastElement;

        for (int i = 0; i < nums.length / 2; i++) {
            temp = nums[i];
            lastElement = nums[nums.length-(i+1)];

            nums[i] = nums[lastElement];
            nums[lastElement] = temp;
        }

        return nums;
    }
}
