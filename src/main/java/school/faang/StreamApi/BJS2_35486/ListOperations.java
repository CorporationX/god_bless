package school.faang.StreamApi.BJS2_35486;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    private static <T> void validateList(List<T> list, String errorMessage) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        validateList(numbers, "Список чисел пуст или null");
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        validateList(numbers, "Список чисел пуст или null");
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow();
    }

    public static double findAverage(List<Integer> numbers) {
        validateList(numbers, "Список чисел пуст или null");
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow();
    }

    public static long countStringsStartingWith(List<String> strings, char letter) {
        validateList(strings, "Список строк пуст или null");
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == letter)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        validateList(strings, "Список строк пуст или null");
        if (substring == null || substring.isEmpty()) {
            throw new IllegalArgumentException("Подстрока пуста или null");
        }
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        validateList(strings, "Список строк пуст или null");
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        validateList(numbers, "Список чисел пуст или null");
        return numbers.stream().allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        validateList(numbers, "Список чисел пуст или null");
        return numbers.stream()
                .filter(n -> n > threshold)
                .min(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("Нет чисел больше заданного порога"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        validateList(strings, "Список строк пуст или null");
        return strings.stream()
                .map(String::length)
                .toList();
    }
}