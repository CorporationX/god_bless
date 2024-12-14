package school.faang.sprint2.bjs_46929;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class OperationsWithLists {

    public static Integer sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Integer findMax(List<Integer> numbers) {
        if (numbers == null) {
            return 0;
        }
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new NullPointerException("empty list"));
    }

    public static Double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("empty list"));
    }

    public static Integer findMinGreaterThan(List<Integer> numbers, int compareInt) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num > compareInt)
                .min()
                .orElseThrow(() -> new NoSuchElementException("no elements greater than" + compareInt));
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> function) {
        if (numbers == null) {
            return false;
        }
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .allMatch(function::test);
    }

    public static Integer countStringsStartingWith(List<String> strings, Character symbol) {
        return (int) strings.stream()
                .filter(string -> string.startsWith(symbol.toString()))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String str) {
        if (strings == null || str == null) {
            return List.of();
        }
        return strings.stream()
                .filter(string -> string.contains(str))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        if (strings == null) {
            return List.of();
        }
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        if (strings == null) {
            return List.of();
        }
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
