package sprint3.stream.training.one;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamTrainer {
    public static int findSumOfEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter(i -> i % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMaxElementAmongNumbers(List<Integer> nums) {
        return nums.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static int findAverageNumber(List<Integer> nums) {
        return (int) nums.stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0);
    }

    public static long findNumberOfLinesWithCertainChar(List<String> strings, char firstLetter) {
        return strings.stream()
                .filter(str -> str.charAt(0) == firstLetter)
                .count();
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(str -> str.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean sortByCorrespondenceForAll(List<String> strings, Predicate<String> condition) {
        return strings.stream()
                .allMatch(condition);
    }

    public static int findSmallestElementThan(List<Integer> nums, int i) {
        return nums.stream()
                .filter(num -> num > i)
                .min(Integer::compareTo)
                .orElse(0);
    }

    public static List<Integer> convertToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
