package faang.school.godbless.calculator;

import java.util.List;

public class ArithmeticOperations {

    public static int calculate(List<Integer> nums, Calculator calculator) {
        listValidation(nums);

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }

        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, Integer::sum);
    }

    private static void listValidation(List<Integer> nums) {
        if (nums == null) {
            throw new IllegalArgumentException("List can't be null");
        }

        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List can't be empty");
        }
    }
}
