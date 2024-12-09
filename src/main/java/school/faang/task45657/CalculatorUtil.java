package school.faang.task45657;

import java.util.List;

public class CalculatorUtil {

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }
        if (calculator == null) {
            throw new IllegalArgumentException("Calculator cannot be null");
        }

        int result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }

        return result;
    }
}
