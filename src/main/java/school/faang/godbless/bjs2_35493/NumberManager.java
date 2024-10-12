package school.faang.godbless.bjs2_35493;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class NumberManager {
    public static int getSumOfEvenNumbers(@NotNull List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int getMaxNumber(@NotNull List<Integer> numbers) {
        return numbers.stream().max(Integer::compareTo).orElseThrow(NoSuchElementException::new);
    }

    public static int getAverage(@NotNull List<Integer> numbers) {
        return (int) numbers.stream().mapToInt(Integer::intValue).average()
                .orElseThrow(() -> new IllegalArgumentException("can not find average of an empty list"));
    }

    public static boolean checkPredicate(@NotNull List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinWithLowerBound(@NotNull List<Integer> numbers, int lowerBound) {
        return numbers.stream().filter(number -> number > lowerBound).min(Integer::compareTo).orElseThrow(NoSuchElementException::new);
    }
}
