package school.faang.sprint2.task_BJS2_60444;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> list) {
        list = getValidList(list);
        return list.stream()
                .filter(integer -> integer % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> list) {
        list = getValidList(list);
        return list.stream()
                .max(Comparator.comparingInt(n -> n)).get();
    }

    public static double findAverage(List<Integer> list) {
        list = getValidList(list);
        return list.stream()
                .mapToInt(Integer::intValue)
                .average().getAsDouble();
    }

    public static long countStringsStartingWith(List<String> list, char chr) {
        list = getValidList(list);
        return list.stream()
                .filter(s -> s.startsWith(String.valueOf(chr)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String subString) {
        validSubString(subString);
        list = getValidList(list);
        return list.stream()
                .filter(s -> s.contains(subString))
                .toList();
    }

    public static List<String> sortByLength(List<String> list) {
        list = getValidList(list);
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> condition) {
        validCondition(condition);
        list = getValidList(list);
        return list.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> list, int start) {
        list = getValidList(list);
        return list.stream()
                .filter(integer -> integer > start)
                .min(Comparator.comparingInt(n -> n)).get();
    }

    public static List<Integer> convertToLengths(List<String> list) {
        list = getValidList(list);
        return list.stream()
                .map(String::length)
                .toList();
    }

    private static <T> List<T> getValidList(List<T> list) {
        if (list == null) {
            throw new IllegalArgumentException("Список не должен быть null");
        }

        List<T> validList = list.stream()
                .filter(Objects::nonNull)
                .toList();

        if (validList.isEmpty()) {
            throw new IllegalArgumentException("Не валидный список: " + list);
        }
        return validList;
    }

    private static void validSubString(String subString) {
        if (subString == null || subString.isBlank()) {
            throw new IllegalArgumentException("Подстрока не может быть null");
        }
    }

    private static void validCondition(Predicate<Integer> condition) {
        if (condition == null) {
            throw new IllegalArgumentException("Условие не может быть null");
        }
    }
}
