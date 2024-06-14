package faang.school.godbless.сalculator;

import java.util.List;

public class CalculatorService {
    private int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if(nums.isEmpty() || nums == null) {
            throw new IllegalArgumentException("Список пуст или равен null");
        }

        int result = nums.get(0);
        for(int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
