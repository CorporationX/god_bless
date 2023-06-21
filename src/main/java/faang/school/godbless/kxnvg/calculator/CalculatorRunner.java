package faang.school.godbless.kxnvg.calculator;

import java.util.List;


public class CalculatorRunner {

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Список чисел пустой");
        } else if (nums == null) {
            throw new NullPointerException("Список не может быть null");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = (int) calculator.operation(result, nums.get(i));
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
