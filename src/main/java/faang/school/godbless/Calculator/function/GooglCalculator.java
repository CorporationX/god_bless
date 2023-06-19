package faang.school.godbless.Calculator.function;

import java.util.List;

public class GooglCalculator {
    private final static Calculator<Integer, Integer> multi = (a, b) -> a * b;

    private final static Calculator<Integer, Integer> sum = (a, b) -> a + b;


    public static int product(List<Integer> nums) {
        return calculate(nums, multi);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, sum);
    }

    private static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = (int) calculator.add(result, nums.get(i));
        }
        return result;
    }
}
