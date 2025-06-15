package school.faang.stream1;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * @author Danil Pudovkin
 * @since 12.06.2025
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ListOperations {

    public static int sumOfEvenNumbers(@NonNull List<Integer> integers) {
        return integers.stream()
                .filter(i -> i % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(@NonNull List<Integer> integers) {
        return integers.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("Максимальное значение не найдено"));
    }

    public static double findAverage(@NonNull List<Integer> integers) {
        return integers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(@NonNull List<String> strings, char prefix) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == prefix)
                .count();
    }

    public static long filterStringsContainingSubstring(@NonNull List<String> strings, @NonNull String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .count();
    }

    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean allMatchCondition(@NonNull List<Integer> integers, @NonNull Predicate<Integer> predicate) {
        return integers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(@NonNull List<Integer> integers, int max) {
        return integers.stream()
                .filter(i -> i > max)
                .min(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("Нет элементов больше %d".formatted(max)));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
