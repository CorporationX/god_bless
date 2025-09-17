package school.faang.bjs2_88187;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        Stream<Integer> evenNumbers = numbers.stream();
        return evenNumbers
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("Пусто"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Пусто"));
    }

    public static long countStringsStartingWith(List<String> strings, char simbol) {
        return strings.stream()

                .filter(s -> s.startsWith(String.valueOf(simbol)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String stringToSearch) {
        return strings.stream()
                .filter(s -> s.contains(stringToSearch))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Переданный список пуст или ничего не содержит");
        }
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream()
                .filter(n -> n > number)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("Пусто"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

    public static <T> void validateListNotNull(List<T> list, String listName) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException(listName + " или его значения, содержат null");
        }

    }
}
