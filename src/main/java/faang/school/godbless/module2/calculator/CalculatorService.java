package faang.school.godbless.module2.calculator;

import java.util.List;

public class CalculatorService {
    public int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        if (nums.size() < 2) {
            throw new IllegalArgumentException("Must contain at least two nums.");
        }
        return nums.stream().reduce(calculator::calc).orElseThrow(IllegalArgumentException::new);
    }

    public int multiplication(List<Integer> nums) {
        return calculate(nums, (firstNumber, secondNumber) -> firstNumber * secondNumber);
    }

    public int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
