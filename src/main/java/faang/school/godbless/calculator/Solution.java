package faang.school.godbless.calculator;

import lombok.NonNull;

import java.util.List;
import java.util.Objects;

public class Solution {
    private static int calculate(@NonNull List<Integer> nums, Calculator calculator) {
        return nums.stream()
                .filter(Objects::nonNull)
                .reduce(calculator::compute).orElseThrow(IllegalArgumentException::new);
    }

    static int sum(List<Integer> nums) {
        return calculate(nums, ((a, b) -> a + b));
    }

    static int product(List<Integer> nums) {
        return calculate(nums, ((a, b) -> a * b));
    }
}

@FunctionalInterface
interface Calculator {
    int compute(int a, int b);
}

