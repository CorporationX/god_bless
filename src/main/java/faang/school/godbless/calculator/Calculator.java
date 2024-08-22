package faang.school.godbless.calculator;

import java.util.List;

public class Calculator {

    public static long calculate(List<Integer> nums, Calculators calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        long result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static long sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static long product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
