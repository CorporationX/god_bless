package school.faang.task_45677;

import java.util.List;

public class OperationProcessor {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        return nums.stream()
                .reduce(calculator::operation).orElse(0);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (first, second) -> first * second);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
