package Calculator;

import java.util.List;

public class Operations {
    public static int calculate(List<Integer> numbers, Calculator calculator) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Empty List");
        }
        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); ++i) {
            result = calculator.calculate(result, numbers.get(i));
        }
        return result;
    }

    public static int sum(List<Integer> numbers) {
        return calculate(numbers, ((a, b) -> a + b));
    }

    public static int product(List<Integer> numbers) {
        return calculate(numbers, ((a, b) -> a * b));
    }
}
