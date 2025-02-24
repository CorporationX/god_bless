package school.faang.sprint2.task47145streamapi1;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static Integer sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Integer findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .orElse(null);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToDouble(Integer::doubleValue)
                .average().orElse(Double.NaN);
    }

    public static Integer countStringsStartingWith(List<String> strings, char ch) {
        List<String> filterStrings = strings.stream()
                .filter(string -> string.charAt(0) == ch).toList();
        return filterStrings.size();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter((string) -> string.contains(substring)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static Integer findMinGreaterThan(List<Integer> numbers, Integer giveNumber) {
        return numbers.stream()
                .filter(number -> number > giveNumber)
                .min(Integer::compareTo)
                .orElse(null);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
