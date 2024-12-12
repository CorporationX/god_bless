package school.faang.task_46829;

import java.util.List;
import java.util.NoSuchElementException;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue).sum();
    }

    public static int maxInt(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Empty"));

    }

}
