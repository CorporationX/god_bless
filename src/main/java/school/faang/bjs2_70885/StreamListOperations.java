package school.faang.bjs2_70885;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class StreamListOperations {

    private StreamListOperations() {
    }

    public static int sumEven(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num % 2 == 0)
                .sum();
    }

    public static int max(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max().orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double average(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average().orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static long countStartWithPrefix(List<String> strings, String prefix) {
        return strings.stream()
                .filter(string -> string.startsWith(prefix))
                .count();
    }

    public static List<String> containSubstring(List<String> strings, String substring) {
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

    public static int getMinGreaterThan(List<Integer> numbers, int bound) {
        return numbers.stream()
                .sorted()
                .filter(number -> number > bound)
                .findFirst().orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static List<Integer> getStringLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
