package school.faang;

import java.util.List;

public class Operations {
    public static <T> T calculate(List<T> numbers, Calculator<T> calculator) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Number list can't be null or empty.");
        } else if (calculator == null) {
            throw new IllegalArgumentException("The calculator can't be null.");
        }
        return numbers.stream()
                .reduce(calculator::calculate)
                .get();
    }

    public static int product(List<Integer> numbers) {
        return calculate(numbers, (a, b) -> a * b);
    }

    public static int sum(List<Integer> numbers) {
        return calculate(numbers, Integer::sum);
    }
}
