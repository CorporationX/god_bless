package faang.school.godbless.lambdas.task_7.util;

import java.util.List;

public class DataCalculator {
    public static long calculate(List<Integer> nums, Calculator<Long, Long> calculator) {
        long result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, (long) nums.get(i));
        }
        return result;
    }

    public static long product(List<Integer> nums) {
        return calculate(nums, (first, second) -> (long) first * second);
    }

    public static long sum(List<Integer> nums) {
        return calculate(nums, Long::sum);
    }
}