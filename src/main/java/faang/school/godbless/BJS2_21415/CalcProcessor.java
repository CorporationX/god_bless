package faang.school.godbless.BJS2_21415;

import java.util.List;

public class CalcProcessor {
    public static long calculate(List<Integer> nums, Calculator calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        long result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.calc(result, nums.get(i));
        }
        return result;
    }

    public static long sum(List<Integer> nums) {
        return calculate(nums, Long::sum);
    }

    public static long product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
