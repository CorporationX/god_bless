package turn_around;

import lombok.ToString;


@ToString
public class Example {
    public Integer[] reverse(Integer[] nums) {
        Integer[] result = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[nums.length - 1 - i];
        }
        return result;
    }
}
