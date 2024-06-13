package faang.school.godbless.Calculator;

import java.util.List;

public class CalculatorProcessor {
    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Zero numbers was given");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculating(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
