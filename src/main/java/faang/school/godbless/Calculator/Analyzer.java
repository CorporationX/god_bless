package faang.school.godbless.Calculator;

import java.util.List;

public class Analyzer {
    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {

        if (nums.size() == 0) {
            throw new IllegalArgumentException("Список пуст.");
        } else if (nums.size() == 1) {
            return nums.get(0);
        }

        int result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = (int) calculator.calculate(result, nums.get(i));
        }

        return result;
    }

    public static int product(List<Integer> nums) {
        Calculator<Integer> calculator = (x, y) -> x * y;
        return calculate(nums, calculator);
    }

    public static int sum(List<Integer> nums) {
        Calculator<Integer> calculator = (x, y) -> x + y;
        return calculate(nums, calculator);
    }
}
