package school.faang.BJS2_58289;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class OperationsWithNumbersAndStrings {

    public static int calculateEventSum(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new NoSuchElementException(
                        "Ошибка: список чисел пуст. Метод maxNumber не может вернуть " +
                                "максимальное значение из пустого списка."));
    }

    public static double avrNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException(
                        "Ошибка: список чисел пуст. Метод avrNumber не может вернуть " +
                                "среднее значение из пустого списка."));
    }

    public static long countStringsStartingWith(List<String> strings, char ch) {
        return strings.stream()
                .filter(str -> !str.isBlank() && str.startsWith(String.valueOf(ch)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> !str.isEmpty() && str.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThanValue(List<Integer> numbers, int value) {
        return numbers.stream()
                .filter(num -> num > value)
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new NoSuchElementException("Нет числа больше %s".formatted(value)));
    }

    public static List<Integer> convertStringsToLength(List<String> strings) {
        return strings.stream()
                .map(String::length
                ).toList();
    }
}
