package school.faang.BJS2_33928_Calculator;

import java.util.List;

public class CalculatorOperations {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        Integer result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (num1, num2) -> num1 * num2);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
