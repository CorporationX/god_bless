package school.faang.task45657;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = List.of(10, 15);
        int sum = Main.sum(list);
        int multiply = Main.product(list);

        System.out.printf("Sum: %d Multiply: %d", sum, multiply);
    }

    public static int sum(List<Integer> nums) {
        return CalculatorUtil.calculate(nums, (a, b) -> a + b);
    }

    public static int product(List<Integer> nums) {
        return CalculatorUtil.calculate(nums, (a, b) -> a * b);
    }
}
