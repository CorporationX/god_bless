package faang.school.godbless.calculator;

import java.util.List;
import java.util.Optional;

public class Calculator {
    static int calculate(List<Integer> nums, Operation<Integer> operation) {
        if (nums.size() < 2 || operation == null) { throw new IllegalArgumentException(); }
        return nums.stream().reduce((a, b) -> operation.calculate(a, b)).get();
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a*b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a+b);
    }
}