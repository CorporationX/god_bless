package calculator;

import java.util.List;

public class Main {

    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (a, b) -> a + b);
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (a, b) -> a * b);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(2, 4, 6);
        System.out.println("Сумма чисел в коллекции = " + sum(list));
        System.out.println("Произведение чисел в коллекции = " + product(list));
    }
}
