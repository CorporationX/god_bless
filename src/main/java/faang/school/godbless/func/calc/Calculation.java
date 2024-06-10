package faang.school.godbless.func.calc;

import java.util.List;

public record Calculation() {

    private static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || calculator == null) {
            throw new IllegalArgumentException("Numbers list and operation cannot be null");
        }
        return nums.stream().reduce(calculator::calculate).orElseThrow();
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
