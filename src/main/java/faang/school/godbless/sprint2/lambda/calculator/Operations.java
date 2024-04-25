package faang.school.godbless.sprint2.lambda.calculator;

import java.util.List;

public class Operations {

    public static long calculate(List<Integer> numbers, Calculator calculator) throws IllegalArgumentException {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List of numbers must not be null or empty.");
        }

        return numbers.stream()
                .mapToLong(Integer::longValue)
                .reduce(calculator::calculate)
                .orElseThrow(() -> new IllegalArgumentException("Unable to reduce the list, operation failed."));
    }

    public static long sum(List<Integer> numbers) {
        return calculate(numbers, (numberFirst, numberSecond) -> (long) numberFirst + numberSecond);
    }

    public static long product(List<Integer> numbers) {
        return calculate(numbers, (numberFirst, numberSecond) -> (long) numberFirst * numberSecond);
    }
}
