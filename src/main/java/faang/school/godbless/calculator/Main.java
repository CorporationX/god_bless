package faang.school.godbless.calculator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static int calculate(List<Integer> numbers, Calculator<Integer> calculator) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("It's NULL");
        }
        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); i++) {
            result = calculator.calculate(result, numbers.get(i));
        }
        return result;
    }

    public static long product(List<Integer> nums) {
        return calculate(nums, (num1, num2) -> num1 * num2);
    }

    public static int sum(List<Integer> nums) {
        return calculate(nums, (num1, num2) -> num1 + num2);
    }

    public static void main(String[] args) {
        List<Integer> lists = Arrays.asList(1, 2, 3, 2);

        long resultProduct = product(lists);
        System.out.println("Произведение чисел во всем списке: " + resultProduct);

        int resultSum = sum(lists);
        System.out.println("Сумма чисел всего списка: " + resultSum);
    }
}