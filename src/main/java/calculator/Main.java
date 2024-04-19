package calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 1073741824);
        System.out.println(product(nums));
        System.out.println(sum(nums));
    }

    public static long calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Список чисел пуст");
        }

        long result = nums.get(0);
        int intermediateResult;
        for (int i = 1; i < nums.size(); i++) {
            intermediateResult = Long.valueOf(result).intValue();
            result = calculator.calculate(intermediateResult, nums.get(i));
        }

        return result;
    }

    public static long product(List<Integer> nums) throws IllegalArgumentException {
        try {
            return calculate(nums, (firstNum, secondNum) -> firstNum * secondNum);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return 0;
        }
    }

    public static long sum(List<Integer> nums) throws IllegalArgumentException {
        try {
            return calculate(nums, (firstNum, secondNum) -> firstNum + secondNum);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return 0;
        }
    }
}
