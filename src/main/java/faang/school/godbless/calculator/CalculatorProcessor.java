package faang.school.godbless.calculator;

import java.util.List;

public class CalculatorProcessor {

    public static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calc(nums.get(i), result);
        }
        return result;
    }
    public static long product(List<Integer> nums) {
        return calculate(nums, (firstNumber, secondNumber) ->  firstNumber * secondNumber);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }


}
