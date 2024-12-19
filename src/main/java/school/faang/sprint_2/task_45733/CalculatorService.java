package school.faang.sprint_2.task_45733;

import java.util.List;

public class CalculatorService {
    private static int calculate(List<Integer> numbers, Calculator calculator) throws IllegalArgumentException {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("The list cannot be empty!");
        }
        int result = numbers.get(0);
        for (int i = 1; i < numbers.size(); ++i) {
            result = calculator.calculate(result, numbers.get(i));
        }
        return result;
    }

    public static int product(List<Integer> numbers) {
        return calculate(numbers, (a, b) -> a * b);
    }

    public static int sum(List<Integer> numbers) {
        return calculate(numbers, Integer::sum);
    }
}
