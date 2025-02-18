package school.faang.streamapione;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListProcessor {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Список не может быть null!");
        }
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxElement(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст!"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Список пуст!"));
    }

    public static Long countStringsStartingWith(List<String> str, char ch) {
        return str.stream().filter(s -> !s.isEmpty() && s.charAt(0) == ch)
                .count();
    }

    public static List<String> filterBySubstring(List<String> str, String substring) {
        if (str == null || substring == null) {
            throw new IllegalArgumentException("Список или подстрока не могут быть null!");
        }
        return str.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allElementsMatch(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findSmallestElementGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n > threshold)
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("Нет элементов больше: " + threshold));
    }

    public static List<Integer> convertStringsToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
