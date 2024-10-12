package school.faang.Lambda.BJS2_33914;

import java.util.List;

@FunctionalInterface
public interface Calculator {
    int operate(int a, int b);

    static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Список чисел не может быть null или пустым");
        }
        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.operate(result, nums.get(i));
        }
        return result;
    }

    static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }
}