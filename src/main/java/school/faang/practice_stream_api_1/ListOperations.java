package school.faang.practice_stream_api_1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static int findEvenSum(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max((num1, num2) -> num1 - num2)
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static double findAverage(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List is empty");
        }
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("No average found"));
    }

    public static long countStringsStartingWith(List<String> lines, char letter) {
        return lines.stream()
                .filter(line -> line.startsWith(String.valueOf(letter)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> lines, String word) {
        return lines.stream()
                .filter(line -> line.contains(word))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> lines) {
        return lines.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int num) {
        return numbers.stream()
                .filter(number -> number > num)
                .min(Comparator.comparingInt(Integer::intValue))
                .orElseThrow(() -> new NoSuchElementException("No number greater than + " + num));
    }

    public static List<Integer> convertToLengths(List<String> lines) {
        return lines.stream()
                .map(String::length)
                .toList();
    }
}
