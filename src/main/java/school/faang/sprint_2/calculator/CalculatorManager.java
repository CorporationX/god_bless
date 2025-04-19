package school.faang.sprint_2.calculator;

import java.util.List;

public class CalculatorManager {
    public static int calculate(List<Integer> nums, Calculator calculator) {
        return nums.stream()
                .reduce(calculator::apply)
                .orElseThrow(() -> new IllegalArgumentException("Список чисел пуст"));
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
