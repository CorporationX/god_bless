package school.faang.collections_stream_api_optional.bjs2;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public final class ListOperations {
    private ListOperations() {
    }

    private static <T> void checkingArguments(Collection<? extends T> collection) {
        Objects.requireNonNull(collection, "Передаваемый параметр не должен быть null");
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Список не должен быть пустым");
        }
    }

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        checkingArguments(numbers);
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        checkingArguments(numbers);
        return numbers.stream()
                .max(Integer::compare)
                .orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        checkingArguments(numbers);
        return numbers.stream()
                .reduce(0, Integer::sum) / (double) numbers.size();
    }

    public static long countStringsStartingWith(List<String> strings, char firstLetter) {
        checkingArguments(strings);
        return strings.stream()
                .filter(string -> !string.isBlank())
                .filter(string -> string.charAt(0) == firstLetter)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        checkingArguments(strings);
        if (substring.isEmpty()) {
            throw new IllegalArgumentException("Параметр содержащий подстроку не должен быть пустым");
        }
        return strings.stream()
                .filter(string -> !string.isBlank())
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        checkingArguments(strings);
        return strings.stream()
                .filter(s -> !s.isBlank())
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        checkingArguments(numbers);
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int thresholdValue) {
        checkingArguments(numbers);
        return numbers.stream()
                .filter(number -> number > thresholdValue)
                .min(Integer::compare).orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        checkingArguments(strings);
        return strings.stream()
                .filter(string -> !string.isEmpty())
                .map(String::length)
                .toList();
    }
}