package faang.school.godbless.BJS2_10535;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Util {

    public static int sumEven(List<Integer> numbers) {
        return numbers.stream().filter(x -> x % 2 == 0).reduce(Integer::sum).orElse(Integer.MIN_VALUE);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream().max(Comparator.naturalOrder()).orElse(Integer.MIN_VALUE);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average().orElse(Double.MIN_VALUE);
    }

    public static long countStartFrom(List<String> strings, String start) {
        return strings.stream().filter(x -> x.startsWith(start)).count();
    }

    public static List<String> filterContains(List<String> strings, String substring) {
        return strings.stream().filter(x -> x.contains(substring)).collect(Collectors.toList());
    }

    public static List<String> sortLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }

    public static <T> boolean allMatch(List<T> list, Predicate<T> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static int findMinBiggerThan(List<Integer> numbers, int ref) {
        return numbers.stream().filter(x -> x > ref).min(Comparator.naturalOrder()).orElse(Integer.MIN_VALUE);
    }

    public static List<Integer> mapToLength(List<String> strings) {
        return strings.stream().map(String::length).collect(Collectors.toList());
    }
}
