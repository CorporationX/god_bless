package calculator;

import java.util.List;

public class Calculate {

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if(nums.isEmpty()) {
            throw new IllegalArgumentException();
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.operation(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }
}
