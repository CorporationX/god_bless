package task_BJS2_60546;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static int getMaxNumber(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(number -> number)
                .max()
                .orElseThrow(() -> new NoSuchElementException("Ошибка на уровне max()\nПричина: Список пуст"));
    }

    public static int getSumOfEvenNumbers(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static double getAverageNumber(@NonNull List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(number -> number)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Ошибка на уровне average()\n" +
                        "Причина: Список пуст"));
    }

    public static long countStringsStartingWith(@NonNull List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(symbol)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(@NonNull List<String> strings,
                                                                @NonNull String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(@NonNull List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(@NonNull List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(@NonNull List<Integer> numbers, int targetNumber) {
        return numbers.stream()
                .filter(number -> number > targetNumber)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Ошибка на уровне min()\nВ списке нет числа больше "
                        + targetNumber));
    }

    public static List<Integer> convertToLengths(@NonNull List<String> strings) {
        return strings.stream()
                .map(String::length)
                .sorted()
                .toList();
    }

}
