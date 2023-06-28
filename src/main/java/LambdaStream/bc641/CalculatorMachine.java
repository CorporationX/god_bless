package LambdaStream.bc641;

import java.util.List;

public class CalculatorMachine {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums.size() < 2) {
            throw new IllegalArgumentException("List must contain at least 2 elements");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;

//        Решение с помощью Stream API
//        return nums.stream().skip(1).reduce(nums.get(0), (num1, num2) -> calculator.calculate(num1, num2));
    }

    public static int product(List<Integer> nums) {
        Calculator calculator = (num1, num2) -> num1 * num2;
        return calculate(nums, calculator);
    }

    public static int sum(List<Integer> nums) {
        Calculator calculator = (num1, num2) -> num1 + num2;
        return calculate(nums, calculator);
    }


}
