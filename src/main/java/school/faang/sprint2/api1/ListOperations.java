package school.faang.sprint2.api1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .reduce(Integer::sum)
                .orElseThrow(() -> new ArithmeticException("Elements can't be defined"));
    }

    public static int findMax(List<Integer> list) {
        return list.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("Max element can't be defined"));
    }

    public static double findAverage(List<Integer> list) {
        return list.stream()
                .reduce(Integer::sum)
                .stream().mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Average element can't be defined"));
    }

    public static int countStringsStartingWith(List<String> strings, char symbol) {
        return (int) strings.stream()
                .filter(word -> word.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String symbols) {
        return strings.stream()
                .filter(word -> word.contains(symbols))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<Integer> allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .filter(condition).toList();
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream().filter(x -> x > threshold)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("Min element can't be defined"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
