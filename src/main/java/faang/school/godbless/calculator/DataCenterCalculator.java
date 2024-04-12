package faang.school.godbless.calculator;

import java.util.List;

public class DataCenterCalculator {
    public static long calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Пустой список");
        }

        long result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate((int) result, nums.get(i));
        }
        return result;
    }

    public static long product(List<Integer> nums) {
        return calculate(nums, (a, b) -> ((long) a * b));
    }

    public static long sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> ((long) a + b));
    }
}
