package school.faang.moduleone.sprinttwo.task_43539;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> source) {
        return source.stream()
                .filter(e -> e % 2 == 0)
                .reduce(Integer::sum)
                .orElseThrow(() -> new RuntimeException("source has no evan elements"));
    }

    public static int findMax(List<Integer> source) {
        return source.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new RuntimeException("source has no elements"));
    }

    public static double findAverage(List<Integer> source) {
        return source.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new RuntimeException("Невозможно вычислить среднее арифметическое"));
    }

    public static int countStringsStartingWith(List<String> stringSource, char firstChar) {
        return (int) stringSource.stream()
                .map(s -> s.startsWith(String.valueOf(firstChar)))
                .filter(b -> b)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> stringSource, String substring) {
        return stringSource.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> source) {
        return source.stream()
                .sorted((a, b) -> a.length() - b.length())
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> source, Predicate<Integer> predicate) {
        return source.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> source, int threshold) {
        return source.stream()
                .filter(e -> e > threshold)
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new RuntimeException("Нет элемента, отвечающего условию"));
    }

    public static List<Integer> convertToLengths(List<String> source) {
        return source.stream()
                .map(String::length)
                .toList();
    }
}
