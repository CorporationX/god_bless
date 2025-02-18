package school.faang.BJS2_57152;

import lombok.NonNull;

import java.util.List;

public class CalculatorLogic {
    private static int calculate(@NonNull List<Integer> nums,
                                 @NonNull Calculator<Integer> calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("nums is empty");
        }
        return nums.stream()
                .reduce(calculator::operation)
                .orElseThrow(() -> new IllegalArgumentException("nums is empty"));
    }

    public int product(@NonNull List<Integer> nums) {
        return calculate(nums, (num1, num2) -> num1 * num2);
    }

    public int sum(@NonNull List<Integer> nums) {
        return calculate(nums, (num1, num2) -> num1 + num2);
    }
}
