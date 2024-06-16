package faang.school.godbless.sprint2.calculator;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int sum = sum(List.of(1, 2, 3, 4));
        System.out.println("sum: " + sum);

        int product = product(List.of(1, 2, 3, 4));
        System.out.println("product: " + product);
    }

    public static <T> T calculate(List<T> nums, Calculator<T> calculator) throws IllegalArgumentException {
        T result = nums.get(0);

        for (int i = 1; i < nums.size(); i++) {
            result = calculator.compute(nums.get(i), result);
        }

        return result;
    }

    public static int sum(List<Integer> nums) {
        if (nums == null) {
            throw  new IllegalArgumentException("Invalid list");
        }

        return calculate(nums, ((firstNumber, secondNumber) -> firstNumber + secondNumber));
    }

    public static int product(List<Integer> nums) {
        if (nums == null) {
            throw  new IllegalArgumentException("Invalid list");
        }

        return calculate(nums, ((firstNumber, secondNumber) -> firstNumber * secondNumber));
    }
}
