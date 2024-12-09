package school.faang.sprint_2.task_43539;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).filter(n -> n % 2 == 0).sum();
    }

    public static int max(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).max()
                .orElseThrow(() -> new IllegalArgumentException("Переданы некорректные данные"));
    }

    public static double average(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average()
                .orElseThrow(() -> new IllegalArgumentException("Переданы некорректные данные"));
    }

    public static int countStringsStartingWith(List<String> strings, char ch) {
        return (int) strings.stream().filter(s -> s.startsWith(String.valueOf(ch))).count();
    }

    public static List<String> filterStringContainingSubstring(List<String> strings, String substring) {
        return strings.stream().filter(s -> s.contains(substring)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream().allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int lowerLimit) {
        return numbers.stream().filter(num -> num > lowerLimit).min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Переданы некорректные данные"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
