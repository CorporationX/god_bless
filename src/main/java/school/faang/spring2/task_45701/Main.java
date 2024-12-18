package school.faang.spring2.task_45701;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(sum(List.of(1.0, 5.0, 10.0)));
        System.out.println(product(List.of(1.0, 5.0, 10.0)));
    }

    public static double product(List<Double> nums) {
        return calculate(nums, (a, b) -> a.doubleValue() * b.doubleValue());
    }

    public static double sum(List<Double> nums) {
        return calculate(nums, (a, b) -> a.doubleValue() + b.doubleValue());
    }

    public static double calculate(List<Double> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("The list is empty or null");
        }
        return nums.stream()
                .reduce((num1, num2) -> calculator.calculate(num1, num2).doubleValue())
                .orElseThrow(() -> new IllegalArgumentException("Unable to calculate result"));
    }
}
