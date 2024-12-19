package school.faang.task_47366;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }

        return numbers.stream()
                .reduce(0, (result, number) -> number % 2 == 0 ? result + number : result);
    }

    public static int findMax(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }

        return numbers.stream()
                .max(Integer::compare)
                .orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }

        int result = numbers.stream()
                .reduce(0, Integer::sum);

        return (double) result / numbers.size();
    }

    public static int countStringsStartingWith(List<String> strings, char ch) {
        if (strings == null) {
            throw new IllegalArgumentException();
        }

        return (int) strings.stream()
                .filter(s -> s != null && !s.isEmpty() && s.charAt(0) == ch)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        if (strings == null || substring == null) {
            throw new IllegalArgumentException();
        }

        return strings.stream()
                .filter(s -> s != null && !s.isEmpty() && s.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException();
        }

        return strings.stream()
                .sorted((a, b) -> Integer.compare(a.length(), b.length()))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        if (numbers == null || condition == null) {
            throw new IllegalArgumentException();
        }

        return numbers.stream()
                .allMatch(condition);
    }

    public static Optional<Integer> findMinGreaterThan(List<Integer> numbers, int limitValue) {
        if (numbers == null) {
            throw new IllegalArgumentException();
        }

        return numbers.stream()
                .filter(a -> a > limitValue)
                .min(Integer::compare);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException();
        }

        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
