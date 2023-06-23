package faang.school.godbless.sprint3.lambdas.calculator;

import faang.school.godbless.sprint3.lambdas.calculator.interfaces.Calculator;

import java.util.List;

public class App {
    public final static String ARRAY_IS_EMPTY_EXCEPTION_MESSAGE = "Array is empty";
    public final static String ARRAY_IS_NULL_EXCEPTION_MESSAGE = "Array is null";

    public static int product(List<Integer> nums) {
        return calculate(nums, ((a, b) -> a * b));
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, ((a, b) -> a + b)); // Как вариант использовать Integer::sum
    }

    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums == null){
            throw new IllegalArgumentException(ARRAY_IS_NULL_EXCEPTION_MESSAGE);
        }
        if (nums.isEmpty()) {
            throw new IllegalArgumentException(ARRAY_IS_EMPTY_EXCEPTION_MESSAGE);
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }

        return result;
    }
}
