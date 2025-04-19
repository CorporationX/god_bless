package school.faang.stream2.streamapipractice1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (sum, n) -> sum += (n % 2 == 0 ? n : 0));
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("Empty list. No max value can be found."));
    }

    public static double computeAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Empty list. No average value can be found."));
    }

    public static int findMinGreaterThan(List<Integer> numbers, int limit) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(number -> number > limit)
                .min()
                .orElseThrow(() -> new NoSuchElementException("No elements greater than " + limit));
    }

    public static long countStringsStartingWith(List<String> strings, Character c) {
        return strings.stream()
                .filter(s -> s.startsWith(c.toString()))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream()
                .allMatch(filter);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
