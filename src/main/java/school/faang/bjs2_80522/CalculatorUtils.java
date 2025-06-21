package school.faang.bjs2_80522;

import java.util.List;

public class CalculatorUtils {
    private static final int START_INDEX = 0;

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым");
        }

        int result = nums.get(START_INDEX);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.apply(result, nums.get(i));
        }
        return result;
    }

    public Integer product(List<Integer> nums) {
        return CalculatorUtils.calculate(nums, (num1, num2) -> num1 * num2);
    }

    public Integer sum(List<Integer> nums) {
        return CalculatorUtils.calculate(nums, Integer::sum);
    }
}
