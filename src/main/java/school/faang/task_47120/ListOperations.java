package school.faang.task_47120;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (acc, num) -> num % 2 == 0 ? acc + num : acc);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Список пуст."));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Список пуст."));
    }

    public static int countStringsStartingWith(List<String> strings, char c) {
        return (int) strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == c)
                .count();

    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String string) {
        return strings.stream()
                .filter(s -> s.contains(string))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int x) {
        return numbers.stream()
                .filter(num -> num > x)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Нет элементов больше " + x));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

}