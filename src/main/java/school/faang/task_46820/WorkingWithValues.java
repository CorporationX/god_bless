package school.faang.task_46820;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WorkingWithValues {
    public static int findEvenSum(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double findAverageValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> strings, char chars) {
        return (int) strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == chars)
                .count();
    }

    public static List<String> filterBySubstring(List<String> strings, String substrings) {
        return strings.stream()
                .filter(s -> s.contains(substrings))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean satisfyTheCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(s -> s < threshold)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Нет элементов больше " + threshold));
    }

    public static List<Integer> mapToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

}
