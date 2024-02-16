package faang.school.godbless.Calculator;

import java.util.List;

public class CalculatorProcess {
    private static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException{
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }
        else {
            Integer num = nums.get(0);
            for (int i=1; i<nums.size(); i++) {
                num = calculator.calculate(num, nums.get(i));
            }
        }
        return 0;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }
}
