package faang.school.godbless.calculator;

import java.util.List;

public class CalculatorUtil {
    public static <T> T calculate(List<T> nums, Calculator<T> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        T result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (x, y) -> x * y);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (x, y) -> x + y);
    }
}