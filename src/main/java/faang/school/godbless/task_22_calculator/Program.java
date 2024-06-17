package faang.school.godbless.task_22_calculator;

import java.util.List;

public class Program {

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null) {
            throw new NullPointerException("null passed");
        } else if (nums.isEmpty()) {
            throw new IllegalArgumentException("The list is empty");
        }

        int result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = calculator.operation(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        Calculator calculator = (a, b) -> a * b;
        return calculate(nums, calculator);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }
}
