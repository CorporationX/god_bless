package school.faang.bjs2_71406;

import java.util.List;

public class IntegerCalculator {
    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Список чисел пуст!");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }

        return result;
    }

    public static int sum(List<Integer> nums) {
        return IntegerCalculator.calculate(nums, Integer::sum);
    }

    public static int product(List<Integer> nums) {
        return IntegerCalculator.calculate(nums, (a, b) -> a * b);
    }
}
