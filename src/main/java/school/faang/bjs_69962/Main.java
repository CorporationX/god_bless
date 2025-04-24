package school.faang.bjs_69962;

import java.util.List;

public class Main {
    public static int calculate(List<Integer> nums, Calculator calculator) {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("empty list");
        }

        int result = nums.get(0);
        for (int i = 1; i < nums.size(); ++i) {
            result = (int) calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        Calculator<Integer> productCalculator = (a, b) -> a * b; //
        return calculate(nums, productCalculator);
    }

    public static int sum(List<Integer> nums) {
        Calculator<Integer> sumCalculator = (a, b) -> a + b;
        return calculate(nums, sumCalculator);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);

        int totalSum = sum(numbers);
        System.out.println("Сумма: " + totalSum);

        int totalProduct = product(numbers);
        System.out.println("Произведение: " + totalProduct);
    }
}

