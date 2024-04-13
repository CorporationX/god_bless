package faang.school.godbless.module.second.lambda.calculator;

import java.util.List;

public class CalculatorService {
    private static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }
    
    public static int product(List<Integer> nums) {
        return calculate(nums, (firstArgument, secondArgument) -> firstArgument * secondArgument);
    }
    
    public static int sum(List<Integer> nums) {
        return calculate(nums, (firstArgument, secondArgument) -> firstArgument + secondArgument);
    }
}
