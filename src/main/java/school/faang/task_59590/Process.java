package school.faang.task_59590;

import java.util.List;
import java.util.NoSuchElementException;

public class Process {

    public static <T> T calculate(List<T> nums, Calculator<T> calculator)
            throws IllegalArgumentException, ArithmeticException {
        if (nums == null || nums.isEmpty()) {
            throw new NoSuchElementException("The list of numbers is empty");
        }
        return nums.stream()
                .reduce(calculator::operation)
                .get();
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, Math::multiplyExact);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Math::addExact);
    }
}