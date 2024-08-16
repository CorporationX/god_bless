package faang.school.godbless.BJS2_21468;

import java.util.List;

public class CalculatorProcessor {
    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("List of nums is null");
        }
        int result = nums.get(0);
        for (int num : nums.subList(1, nums.size())) {
            result = calculator.calculate(result, num);
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (value1, value2) -> value1 * value2);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
