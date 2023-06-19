package faang.school.godbless.secondSprint.Calculator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.doOperation(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    @FunctionalInterface
    public interface Calculator<T> {
        T doOperation(T a, T b);
    }
}
