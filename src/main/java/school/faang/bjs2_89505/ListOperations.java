package school.faang.bjs2_89505;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> list) {
        return list.stream().filter(x -> x % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMax(List<Integer> list) {
        return list.stream().max(Integer::compareTo).orElseThrow(() -> new IllegalArgumentException("Список пуст."));
    }

    public static double findAverage(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> list, char letter) {
        return list.stream().filter(s -> !s.isEmpty() && s.charAt(0) == letter).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> list, String substring) {
        return list.stream().filter(s -> s.contains(substring)).toList();
    }

    public static List<String> sortByLength(List<String> list) {
        return list.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> list, Predicate<Integer> condition) {
        return list.stream().allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> list, int number) {
        return list.stream().filter(x -> x > number).min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Такого числа нет"));
    }

    public static List<Integer> convertToLengths(List<String> list) {
        return list.stream().map(String::length).toList();
    }
}

