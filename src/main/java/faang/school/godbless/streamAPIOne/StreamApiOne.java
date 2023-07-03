package faang.school.godbless.streamAPIOne;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamApiOne {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(Integer::sum)
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameters"));
    }

    public static int getMax(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameters"));
    }

    public static double getAverageNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameters"));
    }

    public static long countLinesStartsWith(List<String> strings, Character symbol) {
        return strings.stream()
                .filter(string -> string.charAt(0) == symbol)
                .count();
    }

    public static List<String> containsSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static <T> boolean areAllMatches(List<T> strings, Predicate<T> predicate) {
        return strings.stream()
                .allMatch(predicate);
    }

    public static Integer minElemAfterProvided(List<Integer> numbers, Integer provided) {
        return numbers.stream()
                .filter(x -> x > provided)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("Invalid parameters"));
    }

    public static List<Integer> convertStringToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
