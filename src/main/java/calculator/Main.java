package calculator;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(2, 1073741823);
        System.out.println(product(nums));
        System.out.println(sum(nums));
    }

    public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
        if (nums == null || nums.isEmpty()) {
            throw new IllegalArgumentException("Список чисел пуст");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }

        return result;
    }

    public static int product(List<Integer> nums) throws IllegalArgumentException {
        try {
            return calculate(nums, (firstNum, secondNum) -> firstNum * secondNum);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return 0;
        }
    }

    public static int sum(List<Integer> nums) throws IllegalArgumentException {
        try {
            return calculate(nums, (firstNum, secondNum) -> firstNum + secondNum);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
            return 0;
        }
    }
}
