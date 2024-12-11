package school.faang.task_47100;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> strings, char symbol) {
        return Math.toIntExact(strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .count());
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String subString) {
        return strings.stream()
                .filter(string -> !string.isBlank() && string.contains(subString))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(number -> number > threshold)
                .min()
                .orElseThrow(() -> new NoSuchElementException("Нет элементов больше " + threshold));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
