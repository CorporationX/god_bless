package faang.school.godbless.bjs2_21427;

import java.util.List;

public class Main {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null) {
            throw new IllegalArgumentException("List of numbers cannot be null");
        }

        return nums.stream()
                .reduce(calculator::execute)
                .orElseThrow(() -> new IllegalArgumentException("List of numbers cannot be empty"));
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
