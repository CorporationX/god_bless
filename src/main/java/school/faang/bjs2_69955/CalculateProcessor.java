package school.faang.bjs2_69955;

import java.util.List;

public class CalculateProcessor {
    public static <T extends Number> T calculate(List<T> nums, Calculator<T> calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List with nums is empty");
        }
        return nums.stream()
                .reduce(calculator::calculate)
                .get();
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}