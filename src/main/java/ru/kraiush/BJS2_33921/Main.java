package ru.kraiush.BJS2_33921;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> nums = List.of(4, 5, 10, -1, 1);
        System.out.println(product(nums));
        System.out.println(sum(nums));
    }

    public static <T extends Number> T calculate(List<T> nums, Calculator<T> calculator) throws IllegalArgumentException {
        if (nums.isEmpty()) {
            throw new IllegalArgumentException("The list is empty");
        }
        T result = nums.get(0);
        for (int i = 1; i < nums.size(); i++) {
            result = calculator.calculate(result, nums.get(i));
        }
        return result;
    }

    public static int product(List<Integer> nums) {
        return calculate(nums, (firstNumber, secondNumber) -> firstNumber * secondNumber);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (firstNumber, secondNumber) -> firstNumber + secondNumber);
    }
}
