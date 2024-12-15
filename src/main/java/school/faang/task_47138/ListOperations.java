package school.faang.task_47138;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    private static final String MESSAGE = "Invalid input data.";

    public static double averageOfList(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(MESSAGE);
        }
        return numbers.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
    }

    public static int maxNumberInList(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(MESSAGE);
        }
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(MESSAGE);
        }
        return numbers.stream().filter(num -> num % 2 == 0).reduce(0, Integer::sum);
    }

    public static int countLinesBeginsOn(List<String> strings, char beginChar) {
        if (strings == null) {
            throw new IllegalArgumentException(MESSAGE);
        }
        return (int) strings.stream().filter(str -> str.startsWith(String.valueOf(beginChar))).count();
    }

    public static List<String> filterLinesBeginOn(List<String> strings, String begin) {
        if (strings == null || begin == null) {
            throw new IllegalArgumentException(MESSAGE);
        }
        return strings.stream().filter(str -> str.contains(begin)).collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException(MESSAGE);
        }
        return strings.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> filter) {
        if (numbers == null) {
            throw new IllegalArgumentException(MESSAGE);
        }
        return numbers.stream().allMatch(filter);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        if (numbers == null) {
            throw new IllegalArgumentException(MESSAGE);
        }
        return numbers.stream().filter(n -> n > number).min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("No such element"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException(MESSAGE);
        }
        return strings.stream().map(String::length).collect(Collectors.toList());
    }
}
