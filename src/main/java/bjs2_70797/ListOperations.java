package bjs2_70797;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int maxValue(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("No value present"));
    }

    public static double averageValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long numberOfLines(List<String> lines, char symbol) {
        return lines.stream()
                .filter(line -> !line.isEmpty() && line.charAt(0) == symbol)
                .count();
    }

    public static List<String> filterByLine(List<String> lines, String line) {
        return lines.stream()
                .filter(l -> l.contains(line))
                .toList();
    }

    public static List<String> sortByLength(List<String> lines) {
        return lines.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allSatisfies(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int minWithCondition(List<Integer> numbers, int condition) {
        return numbers.stream()
                .filter(num -> num > condition)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("No value present"));
    }

    public static List<Integer> convertFromStringsToLength(List<String> lines) {
        return lines.stream()
                .map(String::length)
                .toList();
    }
}
