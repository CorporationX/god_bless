package school.faang.sprint_2.task_46998;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
            .filter(n -> n % 2 == 0)
            .mapToInt(Integer::intValue)
            .sum();
    }

    static int findMax(List<Integer> numbers) {
        return numbers.stream()
            .max(Integer::compare)
            .orElseThrow(() -> new NoSuchElementException("Maximum not found"));
    }

    static double findAverage(List<Integer> numbers) {
        return numbers.stream()
            .mapToInt(Integer::intValue)
            .average()
            .orElse(0.0);
    }

    static long countStringsStartingWith(List<String> strings, char character) {
        return strings.stream()
            .filter(str -> character == str.charAt(0))
            .count();
    }

    static List<String> filterStringsContainingSubstring(List<String> strings, String subString) {
        return strings.stream()
            .filter(str -> str.contains(subString))
            .toList();
    }

    static List<String> sortByLength(List<String> strings) {
        return strings.stream()
            .sorted(Comparator.comparingInt(String::length))
            .toList();
    }

    static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
            .allMatch(condition);
    }

    static int findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream()
            .filter(nmbrs -> nmbrs > number)
            .min(Integer::compare)
            .orElseThrow(() -> new NoSuchElementException("Minimum not found"));
    }

    static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
            .map(String::length)
            .toList();
    }

}
