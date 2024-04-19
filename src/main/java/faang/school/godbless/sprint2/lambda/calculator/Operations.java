package faang.school.godbless.sprint2.lambda.calculator;

import java.util.List;

public class Operations {

    public static int calculate(List<Integer> numbers, Calculator calculator) throws IllegalArgumentException {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("List of numbers must not be null or empty.");
        }

        return numbers.stream()
                .reduce(calculator::calculate)
                .orElseThrow(() -> new IllegalArgumentException("Unable to reduce the list, operation failed."));
    }

    public static int sum(List<Integer> numbers) {
        return calculate(numbers, (numberFirst, numberSecond) -> numberFirst + numberSecond);
    }

    public static int product(List<Integer> numbers) {
        return calculate(numbers, (numberFirst, numberSecond) -> numberFirst * numberSecond);
    }
}
