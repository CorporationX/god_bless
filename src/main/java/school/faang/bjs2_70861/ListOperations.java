package school.faang.bjs2_70861;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue).sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer::max)
                .orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> lines, char character) {
        return lines.stream()
                .filter(line -> !line.isEmpty() && line.charAt(0) == character)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> lines, String subString) {
        return lines.stream()
                .filter(line -> line.contains(subString))
                .toList();
    }

    public static List<String> sortByLength(List<String> lines) {
        return lines.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream().allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int min) {
        return numbers.stream()
                .filter(num -> num > min)
                .reduce(Integer::min)
                .orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> lines) {
        return lines.stream()
                .map(String::length)
                .toList();
    }
}
