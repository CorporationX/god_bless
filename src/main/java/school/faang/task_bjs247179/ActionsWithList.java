package school.faang.task_bjs247179;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ActionsWithList {
    public static int findSumOfEven(List<Integer> list) {
        return list.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> list) {
        return list.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double findAvg(List<Integer> list) {
        return list.stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0.0);
    }

    public static int countFilteredStrings(List<String> list, char ch) {
        return (int) list.stream()
                .filter(string -> string.startsWith(String.valueOf(ch)))
                .count();
    }

    public static List<String> filterStrings(List<String> list, String str) {
        return list.stream()
                .filter(string -> string.contains(str)).toList();
    }

    public static List<String> sortStringsByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean predicateByCondition(List<Integer> list, Predicate<Integer> predicate) {
        return (list.size() == list.stream().filter(predicate).toList().size());
    }

    public static int findMinIntMoreThis(List<Integer> list, int number) {
        return list.stream()
                .filter(integer -> integer > number).min(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("пустой список"));
    }

    public static List<Integer> mapStringsToInt(List<String> list) {
        return list.stream()
                .map(String::length).toList();
    }
}
