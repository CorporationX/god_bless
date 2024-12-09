package school.faang.task45657;

import java.util.List;

public class CalculatorUtil {

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        if (nums == null || nums.size() > 2 || nums.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (calculator == null) {
            throw new IllegalArgumentException("Calculator cannot be null");
        }

        int result = 1;

        for (Integer num : nums) {
            result = calculator.calc(result, num);
        }

        return result;
    }
}
