package school.faang.calculator;

import java.util.List;

public class CalculatorExample {
    public static <T> T calculate(List<T> nums, Calculator<T> calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        T result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            if (nums.get(i) == null) {
                throw new NullPointerException("Null элемент в листе");
            }
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}