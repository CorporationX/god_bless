package calculator;

import java.util.List;

public class CalculatorImpl {
    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("The list of numbers is empty");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }

        return result;
    }

    public static int product(List<Integer> nums) {
        Calculator<Integer> multiplication = (a, b) -> a * b;
        return calculate(nums, multiplication);
    }

    public static int sum(List<Integer> nums) {
        Calculator<Integer> addition = Integer::sum;
        return calculate(nums, addition);
    }
}
