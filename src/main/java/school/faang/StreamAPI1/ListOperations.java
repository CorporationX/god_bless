package school.faang.StreamAPI1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("Cписок пуст"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToDouble(Integer::doubleValue).average().
                orElseThrow(() -> new NoSuchElementException("Cписок пуст"));
    }

    public static int countStringsStartingWith(List<String> strings, char chr) {
        return (int) strings.stream().filter(str -> str.startsWith(String.valueOf(chr))).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String str) {
        return strings.stream().filter(string -> string.contains(str)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int num) {
        return numbers.stream().filter(n -> n > num).min(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("Элемент не найден"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
