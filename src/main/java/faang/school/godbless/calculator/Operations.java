package faang.school.godbless.calculator;

import java.util.List;

public class Operations {
    public static int calculate (List<Integer> nums, Calculator<Integer> calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }

        int result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = calculator.apply(result, nums.get(i));
        }

        return result;
    }

    public static int multiply (List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum (List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }
}
