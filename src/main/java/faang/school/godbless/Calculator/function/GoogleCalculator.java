package faang.school.godbless.Calculator.function;

import java.util.List;

public class GoogleCalculator {
    private final static Calculator<Integer> MULTI = (a, b) -> a * b;

    private final static Calculator<Integer> SUM = (a, b) -> a + b;


    public static int product(List<Integer> nums) {
        return calculate(nums, MULTI);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, SUM);
    }

    private static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.add(result, nums.get(i));
        }
        return result;
    }
}
