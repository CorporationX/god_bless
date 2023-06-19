package faang.school.godbless.ñalculator;

import java.util.List;

public class Operation {
    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.apply(result, nums.get(i));
        }
        return result;
    }
}
