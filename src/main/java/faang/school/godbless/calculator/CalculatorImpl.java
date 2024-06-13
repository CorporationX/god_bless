package faang.school.godbless.calculator;

import java.util.List;

public class CalculatorImpl {

    public static <T extends Number> T calculate(List<T> nums, Calculator<T> calculator) throws IllegalArgumentException {
        if (nums.isEmpty() || nums == null) {
            throw new IllegalArgumentException(
                    "Calculator class calculate method received an empty or non-existent List<Integer>");
        }
        if (calculator == null) {
            throw new IllegalArgumentException(
                    "Calculator class calculate method received a non-existent class Calculate");
        }
        return nums.stream()
                .reduce(calculator::calculate)
                .orElseThrow();
    }

    public int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public int multiplication(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
