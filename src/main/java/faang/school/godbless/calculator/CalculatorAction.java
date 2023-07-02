package faang.school.godbless.calculator;

import java.util.List;

public class CalculatorAction {

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List is empty!");
        }

        Integer result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.run(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (x, y) -> x * y);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (x, y) -> x + y);
    }
}
