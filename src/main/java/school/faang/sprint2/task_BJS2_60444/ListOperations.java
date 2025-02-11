package school.faang.sprint2.task_BJS2_60444;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> list) {
        checkList(list);
        return list.stream()
                .filter(integer -> integer % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> list) {
        checkList(list);
        return list.stream()
                .max(Comparator.comparingInt(n -> n)).orElse(0);
    }

    public static double findAverage(List<Integer> list) {
        checkList(list);
        return list.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(-1);
    }

    public static long countStringsStartingWith(List<String> list, char chr) {
        checkList(list);
        return list.stream()
                .filter(s -> s.startsWith(String.valueOf(chr)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String string) {
        checkList(list);
        return list.stream()
                .filter(s -> s.contains(string))
                .toList();
    }

    public static List<String> sortByLength(List<String> list) {
        checkList(list);
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> predicate) {
        checkList(list);
        return list.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> list, int start) {
        checkList(list);
        return list.stream()
                .filter(integer -> integer > start)
                .min(Comparator.comparingInt(n -> n)).orElse(start);
    }

    public static List<Integer> convertToLengths(List<String> list) {
        checkList(list);
        return list.stream()
                .map(String::length)
                .toList();
    }

    private static <T> void checkList(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Не валидный список: " + list);
        }
    }
}
