package faang.school.godbless.streamApi.streamApi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = List.of(46, 34, 72, 5, 236, 23, 78, 213);
        List<String> strings = List.of("sadfsd", "sad", "fj", "erj", "sgrg");

        System.out.println("sum: " + getSum(nums));
        System.out.println("max: " + getMax(nums));
        System.out.println("average: " + getAverage(nums));
        System.out.println("count strings starts with 's': " + getCountStartsWith(strings, "s"));
        System.out.println("list with substring 'sad': " + getBySubstring(strings, "sad"));
        System.out.println("sorted by length: " + sortByLength(strings));
        System.out.println("check for condition: " + isTrueForEach(strings, s -> s.length() < 6));
        System.out.println("min between nums larger than 70: " + getMinBetweenNumsLargerThan(nums, 70));
        System.out.println("map strings to their lengths: " + getLengths(strings));
    }

    public static int getSum(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(a -> a).sum();
    }

    public static int getMax(List<Integer> nums) {
        return nums.stream()
                .mapToInt(a -> a)
                .max().orElse(0);
    }

    public static double getAverage(List<Integer> nums) {
        return nums.stream()
                .mapToInt(a -> a)
                .average().orElse(0);
    }

    public static long getCountStartsWith(List<String> strings, String character) {
        return strings.stream()
                .filter(s -> s.startsWith(character))
                .count();
    }

    public static List<String> getBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean isTrueForEach(List<String> strings, Predicate<String> condition) {
        return strings.stream().allMatch(condition);
    }

    public static int getMinBetweenNumsLargerThan(List<Integer> nums, int num) {
        return nums.stream()
                .mapToInt(a -> a)
                .filter(a -> a > num)
                .min().orElse(0);
    }

    public static List<Integer> getLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
