package school.faang.task2111.calculator;

import java.util.List;

public class CalculatorService {
    private static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()){
            throw new IllegalArgumentException();
        }
        return nums.stream()
                .skip(1)
                .reduce(nums.get(0), calculator::calculate);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
