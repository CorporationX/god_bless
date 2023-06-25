package faang.school.godbless;

import java.util.List;

public class GoogleCalculator {
    public static int calculate(List<Integer> nums, Calculator calculator) {
        int result = nums.get(0);
        for (int num : nums) {
            result = calculator.Func(result, num);
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }
}
