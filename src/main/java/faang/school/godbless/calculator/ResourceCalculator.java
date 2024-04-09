package faang.school.godbless.calculator;

import java.util.List;

public class ResourceCalculator {

    public int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public int product(List<Integer> nums) {
        return calculate(nums, (first, second) -> first * second);
    }

    public int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
