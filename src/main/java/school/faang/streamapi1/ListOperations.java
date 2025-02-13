package school.faang.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static double DOUBLE_ZERO = 0.0;

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        validateList(numbers);
        return numbers
                .stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        validateList(numbers);
        return numbers
                .stream()
                .max(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("Список пустой"));
    }

    public static double findAverage(List<Integer> numbers) {
        validateList(numbers);
        return numbers
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(DOUBLE_ZERO);
    }

    public static int countStringsStartingWith(List<String> strings, char ch) {
        validateList(strings);
        return (int) strings
                .stream()
                .filter(s -> s != null && !s.isEmpty() && s.charAt(0) == ch)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String sub) {
        validateList(strings);

        if (sub.trim().isEmpty()) {
            throw new IllegalArgumentException("Подстрока не может состоять из пробелов: " + sub);
        }

        return strings
                .stream()
                .filter(s -> s.contains(sub))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        validateList(strings);
        return strings
                .stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> filter) {
        validateList(numbers);

        if (filter == null) {
            throw new NullPointerException("Условие не может быть null");
        }

        return numbers
                .stream()
                .allMatch(filter);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int minNumber) {
        validateList(numbers);
        return numbers
                .stream()
                .filter(n -> n > minNumber)
                .min(Integer::compare)
                .orElseThrow(() ->
                        new NoSuchElementException("Список пуст или все элементы меньше заданного"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        validateList(strings);
        return  strings
                .stream()
                .map(String::length)
                .toList();
    }

    private static <T> void validateList(List<T> numbers) {
        if (numbers == null) {
            throw new NullPointerException("Список не может быть null");
        }

        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым");
        }
    }
}
