package school.faang.calculator;

import java.util.List;

public class Calculate {
    public static int calculate(List<Integer> numbers, Calculator<Integer> calculator) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список пуст");
        }
        return numbers.stream()
                .reduce(calculator::apply)
                .orElseThrow(() -> new IllegalArgumentException("Ошибка при вычислении"));
    }

    public static int sum(List<Integer> numbers) {
        return calculate(numbers, (a, b) -> a + b);
    }

    public static int product(List<Integer> numbers) {
        return calculate(numbers, (a, b) -> a * b);
    }
}