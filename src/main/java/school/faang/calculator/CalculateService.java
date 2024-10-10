package school.faang.calculator;

import java.util.List;

public class CalculateService {
    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    private static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("nums can't by empty");
        }
        return nums.stream()
                .reduce(calculator::calculate)
                .orElseThrow(() -> new IllegalArgumentException("failed"));
    }
}
