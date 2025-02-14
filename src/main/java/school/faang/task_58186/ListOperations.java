package school.faang.task_58186;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("Список пуст или равен null");
        }
        return numbers.stream().filter(integer -> integer % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMax(List<Integer> list) {
        return list.stream().max(Integer::compareTo).orElseThrow(()
                -> new NoSuchElementException("Не удалось найти максимальное значение в пустом списке"));

    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(integer -> integer).average().orElseThrow(()
                -> new NoSuchElementException("в Optional нет обьекта"));
    }

    public static long countStringsStartingWith(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string
                        .isEmpty() && string
                        .charAt(0) == symbol)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream().filter(string -> string.contains(substring)).toList();

    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparing(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream().filter((x) -> x > number).min(Integer::compareTo).orElseThrow(()
                -> new NoSuchElementException("в Optional нет обьекта"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).toList();

    }


}
