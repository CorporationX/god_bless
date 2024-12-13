package school.faang.task_46948;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> list) {
        return requireNonNullList(list).stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> list) {
        return requireNonNullList(list).stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    }

    public static double findAverage(List<Integer> list) {
        return requireNonNullList(list).stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .getAsDouble();
    }

    public static int countStringsStartingWith(List<String> list, char ch) {
        return (int) requireNonNullList(list).stream()
                .filter((str) -> str.startsWith(String.valueOf(ch)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String str) {
        return requireNonNullList(list).stream()
                .filter(s -> s.contains(str))
                .toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return requireNonNullList(list).stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> filter) {
        return requireNonNullList(list).stream().allMatch(filter);
    }

    public static int findMinGreaterThan(List<Integer> list, int num) {
        return requireNonNullList(list).stream()
                .filter(n -> n > num)
                .mapToInt(Integer::intValue)
                .min()
                .getAsInt();
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return requireNonNullList(list).stream()
                .map(String::length)
                .toList();
    }

    private static <T> List<T> requireNonNullList(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("List cannot be null");
        }

        List<T> checkedList = list.stream()
                .filter(Objects::nonNull)
                .toList();

        if (checkedList.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        return checkedList;
    }
}
