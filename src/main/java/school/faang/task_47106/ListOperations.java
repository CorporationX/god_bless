package school.faang.task_47106;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbersList) {
        return numbersList.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, (a, b) -> a + b);
    }

    public static int findMax(List<Integer> numbersList) {
        return numbersList.stream()
                .max((a, b) -> a - b)
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double findAverage(List<Integer> numbersList) {
        return numbersList.stream()
                .mapToInt(x -> x.intValue())
                .average()
                .orElse(0.0);
    }

    public static double countStringsStartingWith(List<String> stringsList, char symbol) {
        return (int) stringsList.stream()
                .filter(str -> !str.isEmpty() && str.charAt(0) == symbol)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> stringsList, String substring) {
        return stringsList.stream()
                .filter(str -> str.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> stringsList) {
        return stringsList.stream()
                .sorted((str1, str2) -> str1.length() - str2.length())
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbersList, int target) {
        return numbersList.stream()
                .filter(x -> x > target)
                .min((a, b) -> a - b)
                .orElseThrow(() -> new NoSuchElementException("Нет элмента больше заданного"));
    }

    public static List<Integer> convertToLengths(List<String> stringsList) {
        return stringsList.stream()
                .map(str -> str.length())
                .collect(Collectors.toList());
    }
}
