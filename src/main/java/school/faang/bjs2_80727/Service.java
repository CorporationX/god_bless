package school.faang.bjs2_80727;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Service {
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max().orElseThrow(() -> new NoSuchElementException("max значение не вычислено"));
    }

    public static double findAvgNumber(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average().orElseThrow(() -> new NoSuchElementException("average значение не вычислено"));
    }

    public static long countStringStartWith(List<String> strings, char firstSymbol) {
        return strings.stream()
                .filter(string -> string.startsWith(Character.toString(firstSymbol)))
                .count();
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatch(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinAndGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num > threshold)
                .min().orElseThrow(() -> new NoSuchElementException("min значение не вычислено"));
    }

    public static List<Integer> stringToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
