package school.faang.practice_streamapi_1;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class StreamApiPractice {
    private static final String NULL_ERROR = "The argument cannot be null.";

    public static int summList(List<Integer> list) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().reduce(0, Integer::sum);
    }

    public static int maxInList(List<Integer> list) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().max(Comparator.naturalOrder())
                .orElseThrow(() -> new IllegalArgumentException("List required!"));
    }

    public static double avgInList(List<Integer> list) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().mapToInt(Integer::intValue).average().orElseThrow(NullPointerException::new);
    }

    public static long findCount(List<String> list, char c) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().filter(i -> i.startsWith(String.valueOf(c))).count();
    }

    public static List<String> includeSubstring(List<String> list, String substring) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().filter(s -> s.contains(substring)).toList();
    }

    public static List<String> lengthSortedList(List<String> list) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().sorted((s1, s2) -> s1.length() - s2.length()).toList();
    }

    public static Boolean isAllMatch(List<Integer> list, Predicate<Integer> predicate) {
        Objects.requireNonNull(list, NULL_ERROR);
        Objects.requireNonNull(predicate, NULL_ERROR);
        return list.stream().allMatch(predicate);
    }

    public static int minOfFilterNumbers(List<Integer> list, int min) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().mapToInt(Integer::intValue).filter(i -> i > min).min().orElseThrow();
    }

    public static List<Integer> mapStringList(List<String> list) {
        Objects.requireNonNull(list, NULL_ERROR);
        return list.stream().map(String::length).toList();
    }
}