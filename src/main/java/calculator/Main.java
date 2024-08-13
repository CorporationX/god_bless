package calculator;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,4);
        System.out.printf("Результат сложения %s = %s", numbers, sum(numbers)).println();
        System.out.printf("Произведение чисел %s = %s", numbers, product(numbers));
    }

    public static int sum(List<Integer> numbers) {
        return calculate(numbers, (a, b) -> a + b);
    }

    public static int product(List<Integer> numbers) {
        return calculate(numbers, (a, b) -> a * b);
    }

    public static int calculate(List<Integer> numbers, Calculator calculator) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Передан пустой список");
        }

        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); ++i) {
            result = calculator.calculate(result, numbers.get(i));
        }
        return result;
    }
}
