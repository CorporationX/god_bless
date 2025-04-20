package school.faang.bjs2_71988;

import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static int findSumOfEvenNumbers(List<Integer> nums) {
        return nums.stream()
            .filter(num -> num % 2 == 0)
            .mapToInt(Integer::valueOf)
            .sum();
    }

    public static int findMaxNum(List<Integer> nums) {
        return nums.stream()
            .max(Integer::compare)
            .orElseThrow();
    }

    public static double findAverage(List<Integer> nums) {
        return nums.stream()
            .mapToInt(Integer::valueOf)
            .average()
            .orElseThrow();
    }

    public static long findNumOfStringsWithFilter(List<String> strs, char ch) {
        return strs.stream()
            .filter(str -> str.charAt(0) == ch)
            .count();
    }

    public static List<String> filterStringsBySubstring(List<String> strs, String subStr) {
        return strs.stream()
            .filter(str -> str.contains(subStr))
            .toList();
    }

    public static List<String> sortStringsByLength(List<String> strs) {
        return strs.stream()
            .sorted((s1, s2) -> s1.length() - s2.length())
            .toList();
    }

    public static boolean filterNums(List<Integer> nums, Predicate<Integer> filter) {
        return nums.stream()
            .allMatch(filter::test);
    }

    public static int findMinNumWithCondition(List<Integer> nums, int num) {
        return nums.stream()
            .filter(i -> i > num)
            .min(Integer::compareTo)
            .orElseThrow();
    }

    public static List<Integer> convertStringsToStiringLengths(List<String> strs) {
        return strs.stream()
            .map(s -> s.length())
            .toList();
    }
}
