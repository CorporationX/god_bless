package school.faang.module1.bjs2_80755;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static long countStringsStartingWith(List<String> strings, char character) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(character)))
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

    public static boolean allMatchCondition(List<Integer> integers, Predicate<Integer> condition) {
        return integers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> integers, int number) {
        return integers.stream()
                .filter(integer -> integer > number)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Ни один элемент не подошёл по фильтру"));
    }

    public static List<Integer> mapToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}