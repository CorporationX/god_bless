package school.faang.collections_stream_api_optional.bjs2_88045;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class ListOperations {
    private static final Predicate<String> isNotNullOrEmpty = string -> string != null && !string.isBlank();
    private static final Predicate<Integer> isNotNullOrGreaterZero = number -> number != null && number >= 0;
    private static final Supplier<NoSuchElementException> noSuchElementException =
            () -> new NoSuchElementException("Список не должен быть пустым");

    private ListOperations() {}

    public static int sumOfEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(isNotNullOrGreaterZero)
                .mapToInt(number -> number)
                .filter(number -> number % 2 == 0)
                .sum();
    }

    public static int findMax(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .max(Integer::compare)
                .orElseThrow(noSuchElementException);
    }

    public static double findAverage(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(isNotNullOrGreaterZero)
                .mapToInt(number -> number)
                .average()
                .orElseThrow(noSuchElementException);
    }

    public static long countStringsStartingWith(@NonNull List<String> strings, char firstLetter) {
        return strings.stream()
                .filter(isNotNullOrEmpty)
                .filter(string -> string.charAt(0) == firstLetter)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(@NonNull List<String> strings, String substring) {
        if (substring.isEmpty()) {
            throw new IllegalArgumentException("Параметр содержащий подстроку не должен быть пустым");
        }
        return strings.stream()
                .filter(isNotNullOrEmpty)
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .filter(isNotNullOrEmpty)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(@NonNull List<Integer> numbers, @NonNull Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(@NonNull List<Integer> numbers, int thresholdValue) {
        return numbers.stream()
                .filter(isNotNullOrGreaterZero)
                .filter(number -> number > thresholdValue)
                .min(Integer::compare)
                .orElseThrow(noSuchElementException);
    }

    public static List<Integer> convertToLengths(@NonNull List<String> strings) {
        return strings.stream()
                .filter(isNotNullOrEmpty)
                .map(String::length)
                .toList();
    }
}