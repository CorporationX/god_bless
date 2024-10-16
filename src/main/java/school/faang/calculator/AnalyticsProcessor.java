package school.faang.calculator;

import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
public class AnalyticsProcessor {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("The list of numbers cannot be null or empty.");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.operate(result, nums.get(i));
        }
        return result;
    }
    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
