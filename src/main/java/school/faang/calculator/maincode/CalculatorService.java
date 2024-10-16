package school.faang.calculator.maincode;

import java.util.List;

public class CalculatorService {
    public int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        int result = nums.get(0);
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }

        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
