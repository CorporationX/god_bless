package faang.school.godbless.Calculator;

import java.util.List;

public class Main {

    private static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        Calculator calculator = (a, b) -> a * b;
        return calculate(nums, calculator);
    }

    public static int sum(List<Integer> nums) {
        Calculator calculator = Integer::sum;
        return calculate(nums, calculator);
    }
}
