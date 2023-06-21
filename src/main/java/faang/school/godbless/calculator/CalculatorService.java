package faang.school.godbless.calculator;

import java.util.List;

public class CalculatorService {

    private static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
       return nums.stream()
           .reduce(calculator::calculate)
           .orElseThrow(() -> new IllegalArgumentException("Cannot calculate with an empty list"));
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (x, y) -> x * y);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
