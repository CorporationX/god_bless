package faang.school.godbless.BJS2_10459;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamAPI {
    public static int evenSum(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int max(List<Integer> nums) {
        return nums.stream()
                .max(Comparator.comparingInt(num -> num))
                .get();
    }

    public static double average(List<Integer> nums) {
        return (double) nums.stream()
                .reduce(0, Integer::sum) / nums.size();
    }

    public static long findStringCount(List<String> strings, String character) {
        return strings.stream()
                .filter(s -> String.valueOf(s.charAt(0)).equalsIgnoreCase(character))
                .count();
    }

    public static List<String> stringsWithSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortedByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static <T> boolean isListRight(List<T> list, Predicate<T> condition) {
        return list.stream()
                .allMatch(condition);
    }

    public static int findMinBiggerThanNum(List<Integer> nums, int num) {
        return nums.stream()
                .filter(n -> n > num)
                .min(Comparator.comparingInt(n -> n))
                .get();
    }

    public static List<Integer> stringsToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
