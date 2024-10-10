package school.faang.listOperations;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.comparingInt(n -> n))
                .orElseThrow(() -> new IllegalArgumentException("Empty list is forbidden!"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Empty list is forbidden!"));
    }

    public static int countLinesWithSymbol(List<String> strings, char ch) {
        return (int) strings.stream()
                .filter(line -> line.charAt(0) == ch)
                .count();
    }

    public static List<String> filterLinesBySubstring(List<String> strings, String str) {
        return strings.stream()
                .filter(line -> line.contains(str))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((str1, str2) -> str1.length() - str2.length())
                .toList();
    }

    public static boolean checkIfAllMatch(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream()
                .allMatch(filter);
    }

    public static int findMinMoreThan(List<Integer> numbers, int thresh) {
        return numbers.stream()
                .filter(number -> number > thresh)
                .min(Comparator.comparingInt(n -> n))
                .orElseThrow(() -> new IllegalArgumentException("Empty list is forbidden!"));
    }

    public static List<Integer> mapToLengths(List<String> lines) {
        return lines.stream()
                .map(String::length)
                .toList();
    }
}
