package faang.school.godbless.BJS2_21493;

import java.util.List;

public class CalculatorService {
    public int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        int result = nums.get(0);

        for (int index = 1; index < nums.size(); index++) {
            result = calculator.calculate(result, nums.get(index));
        }
        return result;
    }

    public int multiply(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public int divide(List<Integer> nums) {
        return calculate(nums, (a, b) -> a / b);
    }

    public int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public int subtract(List<Integer> nums) {
        return calculate(nums, (a, b) -> a - b);
    }
}
