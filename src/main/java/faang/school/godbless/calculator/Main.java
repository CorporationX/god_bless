package faang.school.godbless.calculator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> nums = List.of(10, 10);
        System.out.println("Sum result: " + sum(nums));
        System.out.println("Multiply result: " + product(nums));
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (firstNumber, secondNumber) -> firstNumber * secondNumber);
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }
}
