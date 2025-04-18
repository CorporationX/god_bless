package school.faang.bjs271922;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class ListOperations {

    public static List<Integer> numbersRange(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .boxed()
                .toList();
    }

    public static int evenNumbersSum(List<Integer> numbersList) {
        return numbersList.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbersList) {
        return numbersList.stream()
                .max(Integer::compareTo)
                .orElseThrow();
    }

    public static double findAverage(List<Integer> numbersList) {
        return numbersList.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> strings, char ch) {
        return strings.stream()
                .filter(string -> !string.isEmpty() && string.charAt(0) == ch)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings,
                                                                String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream()
                .filter(num -> num > number)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Нет элементов больше %s".formatted(number)));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}