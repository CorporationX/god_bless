package faang.school.godbless.streamapi_1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamLib {
    public static Integer evenList(List<Integer> list) {
        return list.stream().filter(num -> num % 2 == 0).reduce(Integer::sum).orElse(0);
    }

    public static Integer maxNumber(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    public static Double averageList(List<Integer> list) {
        return list.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public static Integer grepCount(List<String> list, String pattern) {
        return (int) list.stream().filter(s -> s.startsWith(pattern)).count();
    }

    public static List<String> regexFilter(List<String> list, String pattern) {
        return list.stream().filter(s -> s.contains(pattern)).toList();
    }

    public static List<String> stringLengthSorter(List<String> list) {
        return list.stream().sorted(Comparator.comparing(String::length)).toList();
    }

    public static <T> boolean customFilter(List<T> list, Predicate<T> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static Integer minMax(List<Integer> list, Integer min) {
        return list.stream().filter(num -> num >= min).min(Integer::compareTo).orElse(0);
    }

    public static List<Integer> stringLengths(List<String> list) {
        return list.stream().map(String::length).toList();
    }
}
