package school.faang.task_59590;

import java.util.List;
import java.util.NoSuchElementException;

public class Process {

    public static <T> T calculate(List<T> nums, Calculator<T> calculator)
            throws IllegalArgumentException, ArithmeticException {
        return nums.stream()
                .reduce(calculator::operation).
                orElseThrow(() -> new NoSuchElementException("The list of numbers is empty"));
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, Math::multiplyExact);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Math::addExact);
    }
}