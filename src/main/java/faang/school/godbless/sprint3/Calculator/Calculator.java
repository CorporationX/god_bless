package faang.school.godbless.sprint3.Calculator;

import java.util.List;

public interface Calculator<T> {

    T calculate(T value1, T value2);

    static int calculate(List<Integer> nums, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (nums == null) {
            throw new IllegalArgumentException("list is null");
        }
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
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
