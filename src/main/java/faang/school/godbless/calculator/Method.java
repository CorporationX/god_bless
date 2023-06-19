package faang.school.godbless.calculator;

import java.util.List;

public class Method {
    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums.isEmpty() || nums == null) {
            throw new IllegalArgumentException("List cannot be empty!");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;

    }

    public static int product(List<Integer> nums) {
        return calculate(nums, ((a, b) -> a * b));
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, ((a, b) -> a + b));
    }
}
