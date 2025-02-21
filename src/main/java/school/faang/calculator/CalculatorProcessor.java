package school.faang.calculator;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class CalculatorProcessor {

    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums == null) {
            log.info("String is null");
            throw new IllegalArgumentException("String is null");
        }
        if (nums.isEmpty()) {
            log.info("String is empty");
            throw new IllegalArgumentException("String is empty");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.operation(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

}
