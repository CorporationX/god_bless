package school.faang.task_46837;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n != null && n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double findAverage(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double countStringsStartingWith(@NonNull List<String> strings, char c) {
        return strings.stream()
                .filter(s -> s != null && !s.isEmpty() && s.charAt(0) == c)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(@NonNull List<String> strings,
                                                                @NonNull String substring) {
        return strings.stream()
                .filter(s -> s != null && s.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(@NonNull List<Integer> numbers, @NonNull Predicate<Integer> condition) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .allMatch(condition);
    }

    public static int findMinGreaterThan(@NonNull List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n != null && n > threshold)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException(String.format("Нет элементов больше %d", threshold)));
    }

    public static List<Integer> convertToLengths(@NonNull List<String> strings) {
        return strings.stream()
                .filter(Objects::nonNull)
                .map(String::length)
                .toList();
    }

}
