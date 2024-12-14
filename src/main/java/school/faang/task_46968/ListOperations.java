package school.faang.task_46968;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    private static final String ERROR_MESSAGE = "Некорректные входные параметры!";

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return numbers.stream().filter(num -> num != null && num % 2 == 0).reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return numbers.stream()
                .filter(Objects::nonNull)
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст!"));
    }

    public static double findAverage(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return numbers.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.averagingInt(Integer::intValue));
    }

    public static int countStringsStartingWith(List<String> strings, char ch) {
        if (strings == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return (int) strings.stream().filter(str -> str != null && !str.isBlank() && str.charAt(0) == ch).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        if (strings == null || substring == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return strings.stream().filter(s -> s != null && s.contains(substring)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return strings.stream().filter(Objects::nonNull).sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> integers, Predicate<Integer> filter) {
        if (integers == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return integers.stream().filter(Objects::nonNull).allMatch(filter);
    }

    public static int findMinGreaterThan(List<Integer> integers, int number) {
        if (integers == null || integers.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return integers.stream()
                .filter((element) -> element != null && element > number)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Все элементы меньше или равны " + number));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }

        return strings.stream().filter(Objects::nonNull).map(String::length).toList();
    }
}

