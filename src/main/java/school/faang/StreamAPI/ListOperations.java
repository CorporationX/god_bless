package school.faang.StreamAPI;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    /*1*/
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        checkNumbers(numbers);
        return numbers.stream()
                .filter(y -> y % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /*2*/
    public static int maxNumbers(List<Integer> numbers) {
        checkNumbers(numbers);
        return numbers.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    /*3*/
    public static double findAverage(List<Integer> numbers) {
        checkNumbers(numbers);
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    /*4*/
    public static long countStringsStartingWith(List<String> strings, char c) {
        chekStrings(strings);
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == c)
                .count();
    }

    /*5*/
    public static List<String> filterStringsBySubstring(List<String> strings,
                                                        String substring) {
        if (substring.length() <= 1 || (substring.isBlank())) {
            throw new IllegalArgumentException("ведите подстроку");
        }
        return strings.stream()
                .filter((string -> string.contains(substring)))
                .toList();
    }

    /*6*/
    public static List<String> sortByLength(List<String> strings) {
        chekStrings(strings);
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    /*6.1*/
    public static List<String> sortByLengthReversed(List<String> strings) {
        chekStrings(strings);
        return strings.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    /*7*/
    public static boolean allMatchConditionList(
            List<Integer> numbers, Predicate<Integer> predicate) {
        checkNumbers(numbers);
        return numbers.stream()
                .allMatch(predicate);
    }

    /*8*/
    public static int findMinGreaterThan(
            List<Integer> numbers, int threshold) {
        checkNumbers(numbers);
        return numbers.stream()
                .filter(x -> x > threshold)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Нет элементов больше " + threshold));
    }

    /*9*/
    public static List<Integer> mapToLengths(List<String> strings) {
        chekStrings(strings);
        return strings.stream()
                .map(String::length)
                .toList();
    }

    public static void chekStrings(List<String> strings) {
        if (strings.isEmpty() || strings.size() < 2) {
            throw new IllegalArgumentException("List пуст или мало символов");
        }
    }

    public static void checkNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список не может быть пустым или null");
        }
    }
}