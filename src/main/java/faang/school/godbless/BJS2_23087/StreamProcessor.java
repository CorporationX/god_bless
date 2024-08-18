package faang.school.godbless.BJS2_23087;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class StreamProcessor {
    public static int sumEvenNumbers(List<Integer> nums) {
        validateNotNull(nums);
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Optional<Integer> findMaxNumber(List<Integer> nums) {
        validateNotNull(nums);
        return nums.stream()
                .max(Integer::compareTo);
    }

    public static OptionalDouble findAvgOfNumbers(List<Integer> nums) {
        validateNotNull(nums);
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average();
    }

    public static long countStringsStartingWith(char prefix, List<String> strings) {
        validateNotNull(strings);
        return strings.stream()
                .filter(string -> string != null && !string.isEmpty() && string.charAt(0) == prefix)
                .count();
    }

    public static Optional<List<String>> filterStringsBySubstring(String substring, List<String> strings) {
        validateNotNull(strings);
        validateNotNull(substring);
        return Optional.of(strings.stream()
                .filter(string -> string.contains(substring))
                .toList());
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        validateNotNull(strings);
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatch(List<String> strings, Predicate<String> condition) {
        validateNotNull(strings);
        return strings.stream()
                .allMatch(condition);
    }

    public static Optional<Integer> findMinNumberThan(int number, List<Integer> nums) {
        validateNotNull(nums);
        return nums.stream()
                .filter(num -> num > number)
                .min(Integer::compareTo);
    }

    public static List<Integer> mapToStringsLength(List<String> strings) {
        validateNotNull(strings);
        return strings.stream()
                .map(String::length)
                .toList();
    }

    private static <T> void validateNotNull(T obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Object cannot be null");
        }
    }
}
