package faang.school.godbless.secondSprint.Calculator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
    }

    public static <T extends Number> T calculate(List<T> nums, Calculator<T> calculator)
            throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Empty list");
        }

        T result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.doOperation(result, nums.get(i));
        }
        return result;
    }

    public static int productInt(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static double productDouble(List<Double> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sumInt(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static double sumDouble(List<Double> nums) {
        return calculate(nums, Double::sum);
    }

    @FunctionalInterface
    public interface Calculator<T> {
        T doOperation(T a, T b);
    }
}
