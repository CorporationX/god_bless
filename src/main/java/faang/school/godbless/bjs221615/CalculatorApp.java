package faang.school.godbless.bjs221615;

import java.util.List;

public class CalculatorApp {
    public double multiply(List<Double> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public double add(List<Double> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public double substract(List<Double> nums) {
        return calculate(nums, (a, b) -> a - b);
    }

    public double divide(List<Double> nums) {
        return calculate(nums, (a, b) -> a / b);
    }

    private double calculate(List<Double> nums, Calculator<Double> calculator) {
        if (nums.isEmpty()) throw new IllegalArgumentException("empty list");
        double result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }
}