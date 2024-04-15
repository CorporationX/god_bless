package faang.school.godbless.sprint_2.practice_stream_1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println(sumEvenNumbers(List.of(1, 2, 3, 4, 5)));
        System.out.println(findMax(List.of(1, 9, 3, 4, 5)));
        System.out.println(findAvg(List.of(1, 9, 3, 4, 5)));
        System.out.println(findStringsStartsWith(List.of("test", "exit", "double", "temp"), "te"));
        System.out.println(findStringsContainsSubstring(List.of("test", "exit", "double", "temp", "empire"), "em"));
        System.out.println(filterStringsByLength(List.of("esc", "exit", "double", "temp", "empire")));
        System.out.println(filterList(List.of(1, 2, 3, 4, 5, 6, 7, 8), (num) -> num % 2 == 0));
        System.out.println(filterList(List.of("to", "for", "day", "test", "number"), (num) -> num.length() % 2 == 0));
        System.out.println(findMinGreaterThanK(List.of(9, 3, 10, 5, 6), 5));
        System.out.println(transformToLengthList(List.of("a", "aa", "aaa", "aaaa")));
    }

    public static int sumEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(Integer::sum)
                .get();
    }

    public static int findMax(List<Integer> nums) {
        return nums.stream()
                .max(Integer::compareTo)
                .get();
    }

    public static double findAvg(List<Integer> nums) {
        return nums.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .getAsDouble();
    }

    public static List<String> findStringsStartsWith(List<String> strings, String startsWith) {
        return strings.stream()
                .filter(s -> s.startsWith(startsWith))
                .toList();
    }

    public static List<String> findStringsContainsSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> filterStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static <T> List<T> filterList(List<T> list, Predicate<T> filter) {
        return list.stream()
                .filter(filter)
                .toList();
    }

    public static int findMinGreaterThanK(List<Integer> nums, int k) {
        return nums.stream()
                .filter(num -> num > k)
                .min(Integer::compareTo)
                .get();
    }

    public static List<Integer> transformToLengthList(List<String> nums) {
        return nums.stream()
                .map(String::length)
                .toList();
    }
}