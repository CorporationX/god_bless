package school.faang.bjs2_58250;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        validate(numbers);
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        validate(numbers);
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("List is empty, cannot determine max value"));
    }

    public static double findAverage(List<Integer> numbers) {
        validate(numbers);
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> strings, char prefix) {
        validate(strings);
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(prefix)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        validate(strings);
        validate(substring);
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        validate(strings);
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        validate(numbers);
        validate(condition);
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        validate(numbers);
        return numbers.stream()
                .filter(n -> n > threshold)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("No number greater than " + threshold));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        validate(strings);
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    private static <T> void validate(T obj) {
        Objects.requireNonNull(obj, "Value cannot be null");
    }
}
