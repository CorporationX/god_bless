package faang.school.godbless.BJS2_21415;

import java.util.List;

public class CalcProcessor {
    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.calc(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
