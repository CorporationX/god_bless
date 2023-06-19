package faang.school.godbless.calculator;

import java.util.List;

public class Operations {
    static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums == null) {
            throw new IllegalArgumentException("nums is null");
        }
        if (nums.isEmpty()) {
            return 0;
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            int num = nums.get(i);
            result = calculator.calculate(result, num);
        }
        return result;
    }

    static int calculateUseStream(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums == null) {
            throw new IllegalArgumentException("nums is null");
        }
        if (nums.isEmpty()) {
            return 0;
        }
        return nums.stream().reduce(calculator::calculate).get();
    }

    static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    static int sumUseStream(List<Integer> nums) {
        return calculateUseStream(nums, Integer::sum);
    }

    static int product(List<Integer> nums) {
        return calculate(nums, (val1, val2) -> val1 * val2);
    }

    static int productUseStream(List<Integer> nums) {
        return calculateUseStream(nums, (val1, val2) -> val1 * val2);
    }
}
