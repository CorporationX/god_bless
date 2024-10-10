package school.faangSprint2.t14;

import java.util.List;

public class CalculatorImplementation {

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.operate(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) throws IllegalArgumentException {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) throws IllegalArgumentException {
        return calculate(nums, (a, b) -> a + b);
    }
}