package faang.school.godbless.calculator;

import lombok.NonNull;

import java.util.List;

public class Main {

    public static int calculate(@NonNull List<Integer> nums, @NonNull Calculator calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int product(@NonNull List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(@NonNull List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }
}
