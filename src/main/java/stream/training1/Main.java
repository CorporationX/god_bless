package stream.training1;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        System.out.println(getSumOfEvenNumbers(List.of(1, 2, 3, 4, 5, 6)));
        System.out.println(getMax(List.of(1, 2, 3, 4, 5, 6)));
        System.out.println(getAverage(List.of(1, 2, 3, 4, 5, 6)));
        System.out.println(getStringsStartsWithCount(List.of("abc", "abd", "dbf"), "ab"));
        System.out.println(getFilteredListOfStringsContainsSubstring(List.of("abc", "abd", "dbf"), "f"));
        System.out.println(getSortedByStringLengthList(List.of("abababa", "asfas", "11", "asf")));
        System.out.println(isAllElementsMatchCondition(List.of(2.5, 3.4, 5.4, 4.0), e -> e > 2));
        System.out.println(getMinElementGreaterThan(List.of(1, 2, 3, 4, 5, 6), 3));
        System.out.println(getStringLengths(List.of("abababa", "asfas", "11", "asf")));
    }

    public static int getSumOfEvenNumbers(@NonNull List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int getMax(@NonNull List<Integer> nums) {
        return nums.stream()
                .max(Integer::compareTo)
                .orElseThrow();
    }

    public static double getAverage(@NonNull List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow();
    }

    public static long getStringsStartsWithCount(@NonNull List<String> lines, @NonNull String pattern) {
        return lines.stream()
                .filter(line -> line.startsWith(pattern))
                .count();
    }

    public static List<String> getFilteredListOfStringsContainsSubstring(@NonNull List<String> lines, @NonNull String substring) {
        return lines.stream()
                .filter(line -> line.contains(substring))
                .toList();
    }

    public static List<String> getSortedByStringLengthList(@NonNull List<String> lines) {
        return lines.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static <T> boolean isAllElementsMatchCondition(@NonNull List<T> elements, @NonNull Predicate<T> condition) {
        return elements.stream()
                .allMatch(condition);
    }

    public static int getMinElementGreaterThan(@NonNull List<Integer> nums, int min) {
        return nums.stream()
                .filter(num -> num > min)
                .min(Integer::compareTo)
                .orElseThrow();
    }

    public static List<Integer> getStringLengths(@NonNull List<String> lines) {
        return lines.stream()
                .map(String::length)
                .toList();
    }
}
