package school.faang.calculator;

import java.util.List;

public class CalculatorExample {
    public static <T extends Number> T calculate(List<T> nums, Calculator<T> calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        nums.forEach(num -> {
            if (num == null) {
                throw new IllegalArgumentException("Null элемент в листе");
            }
        });

       return nums.stream().reduce(calculator::calculate).get();
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}