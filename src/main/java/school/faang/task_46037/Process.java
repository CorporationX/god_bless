package school.faang.task_46037;

import java.util.List;

public class Process {

    public static <T> T calculate(List<T> nums, Calculator<T> calculator)
            throws IllegalArgumentException, ArithmeticException {
        return nums.stream()
                .reduce(calculator::operation).orElseThrow();
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, Math::multiplyExact);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (Math::addExact));
    }
}