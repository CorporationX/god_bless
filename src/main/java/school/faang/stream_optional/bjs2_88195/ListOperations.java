package school.faang.stream_optional.bjs2_88195;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new NoSuchElementException("Не удалось найти максимальное значение. " +
                        "Возможная причина: передан пустой список"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static long countStringsStartingWith(List<String> stringList, char startChar) {
        return stringList.stream()
                .filter(s -> s.startsWith(String.valueOf(startChar)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> stringList, String containsString) {
        return stringList.stream()
                .filter(s -> s.contains(containsString))
                .toList();
    }

    public static List<String> sortByLength(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream()
                .allMatch(filter);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int filterNumber) {
        return numbers.stream()
                .filter(number -> number > filterNumber)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException(
                        "Не удалось найти минимальное значение после числа " +
                                "%d. Возможная причина: передан пустой список".formatted(filterNumber)));
    }

    public static List<Integer> convertToLengths(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .toList();
    }
}