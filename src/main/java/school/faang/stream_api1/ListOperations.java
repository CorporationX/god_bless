package school.faang.stream_api1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxElement(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .orElse(Integer.MIN_VALUE);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::intValue)
                .average()
                .orElse(0.0); // Возвращаем 0.0 если список пуст
    }

    public static long countStringsStartingWith(List<String> strings, char symbol) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == symbol)
                .count();
    }

    public static List<String> filterStringsContaining(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allElementsMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findSmallestGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n > threshold)
                .min(Integer::compare)
                .orElse(Integer.MAX_VALUE);
    }

    public static List<Integer> transformToStringLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }


}