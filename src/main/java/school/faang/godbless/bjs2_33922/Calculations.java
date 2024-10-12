package school.faang.godbless.bjs2_33922;

import lombok.NonNull;

import java.util.List;
import java.util.stream.IntStream;

public class Calculations {
    public static int calculate(@NonNull List<Integer> numbers, Calculator<Integer> calculator) throws IllegalArgumentException {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return IntStream.range(1, numbers.size()).map(numbers::get).reduce(numbers.get(0), calculator::doOperation);
    }

    public static int product(@NonNull List<Integer> numbers) {
        return calculate(numbers, (a, b) -> a * b);
    }

    public static int sum(@NonNull List<Integer> numbers) {
        return calculate(numbers, Integer::sum);
    }
}
