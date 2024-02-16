package faang.school.godbless.calculator;

import java.util.List;


public class Main {
    public static void main(String... args) {
        List<Integer> nums = java.util.List.of(1, 2, 3, 4, 5);
        System.out.println("sum = " + sum(nums));
        System.out.println("muptiply = " + product(nums));
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, ((firstNumber, secondNumber) -> firstNumber + secondNumber));
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, ((firstNumber, secondNumber) -> firstNumber * secondNumber));
    }

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }
}
