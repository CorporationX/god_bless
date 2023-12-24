package faang.school.godbless.calculator;

import java.util.List;

public class Operations {
    public static long calculate (List<Long> nums, Calculator<Long> calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }

        long result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = calculator.apply(result, nums.get(i));
        }

        return result;
    }

    public static long multiply (List<Long> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static long sum (List<Long> nums) {
        return calculate(nums, (a, b) -> a + b);
    }
}
