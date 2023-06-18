package faang.school.godbless.lambda.calculator;

import java.util.List;

public class CalcMethods {
    private static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        int sum = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            sum = calculator.calcMethod(sum, nums.get(i));
        }
        return sum;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, ((a, b) -> a * b));
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }
}
