package school.faang.bjs2_88117;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static double findAverage(List<Integer> numbers) {
        double sum = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
        return sum / numbers.size();
    }

    public static long countStringsStartingWith(List<String> strings, char c) {
        return strings.stream()
                .filter(string -> string.charAt(0) == c)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String word) {
        return strings.stream()
                .filter(string -> string.contains(word))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(number -> predicate.equals(number));
    }

    public static int findMinGreaterThan(List<Integer> numbers, int x) {
        return numbers.stream()
                .filter(number -> number > x)
                .min(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(string -> string.length())
                .toList();
    }
}
