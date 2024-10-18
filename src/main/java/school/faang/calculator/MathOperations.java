package school.faang.calculator;

import java.util.List;

public class MathOperations {

    public static int calculate(List<Integer> numbers, Calculator calculator) throws IllegalArgumentException {
        if (numbers.isEmpty() || numbers == null) {
            throw new IllegalArgumentException("Список чисел не может быть пустым.");
        }

        int result = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            result = (int) calculator.apply(result, numbers.get(i));
        }

        return result;
    }

    public static int product(List<Integer> numbers) {
        return calculate(numbers, (a, b) -> ((int) a * ((int) b)));
    }

    public static int sum(List<Integer> numbers) {
        return calculate(numbers, (a, b) -> ((int) a + (int) b));
    }
}

