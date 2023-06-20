package faang.school.godbless.sprint3.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public interface Calculator<T> {

    Logger LOGGER = LoggerFactory.getLogger(Calculator.class);

    T calculate(T value1, T value2);

    static int calculate(List<Integer> nums, Calculator<Integer> calculator) {
        if (nums.isEmpty()) {
            LOGGER.error("Empty list");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }
}
