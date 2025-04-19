package school.faang.calculator;

import java.util.List;

public class CalculateProcess {
    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.apply(result, nums.get(i));
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
