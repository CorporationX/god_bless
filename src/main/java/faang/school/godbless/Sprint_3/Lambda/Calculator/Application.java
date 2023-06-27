package faang.school.godbless.Sprint_3.Lambda.Calculator;

import java.util.List;

public class Application {

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException();
        }
        int result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = calculator.operate(result, nums.get(i));
        }

        return result;
    }

    public static int product(List<Integer> nums) {
        Calculator productCalculator = (int a, int b) -> a * b;
        return calculate(nums, productCalculator);
    }

    public static int sum(List<Integer> nums) {
        Calculator sumCalculator = (int a, int b) -> a + b;
        return calculate(nums, sumCalculator);
    }

}
