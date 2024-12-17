package school.faang.task_47160;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(num -> num)
                .filter(x -> x % 2 == 0)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("list is empty"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(num -> num)
                .average()
                .orElseThrow(() -> new NoSuchElementException("list is empty"));
    }

    public static int countStringsStartingWith(List<String> strings, char start) {
        return (int) strings.stream()
                .filter(str -> str.startsWith(String.valueOf(start)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(x -> x.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static Integer findMinGreaterThan(List<Integer> numbers, int x) {
        return numbers.stream()
                .filter(y -> y > x)
                .min(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("Нет элементов больше заданного значения"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
