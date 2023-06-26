package faang.school.godbless.lambda.calculator;

import java.util.List;

public class GoogleCalculator {
    private static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("������ ����� ����� null ��� ����!");
        }
        if (calculator == null) {
            throw new IllegalArgumentException("����� ��� ������� ����� ����� null!");
        }

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
        return calculate(nums, (a, b) -> a + b);
    }
}
