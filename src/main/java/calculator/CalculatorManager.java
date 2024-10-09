package calculator;

import java.util.List;

public class CalculatorManager {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List nums is not be empty");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = (int) calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> (int) a + (int) b);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> (int) a * (int) b);
    }
}
