package faang.school.godbless.lambdas.calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(5000, 33, 4, 2);
        System.out.println("Перемножение: " + product(nums));
        System.out.println("Суммирование: " + sum(nums));
        System.out.println("Целочисленное деление: " + div(nums));
        System.out.println("Вычитание: " + sub(nums));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("Passed empty list");
        }
        if (nums.size() == 1) {
            throw new IllegalArgumentException("Passed one number only");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (num1, num2) -> num1 * num2);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (num1, num2) -> num1 + num2);
    }

    public static int div(List<Integer> nums) {
        return calculate(nums, (num1, num2) -> {
            if (num2 == 0) {
                throw new IllegalArgumentException("Dividing by zero");
            }
            return num1 / num2;
        });
    }

    public static int sub(List<Integer> nums) {
        return calculate(nums, (num1, num2) -> num1 - num2);
    }
}
