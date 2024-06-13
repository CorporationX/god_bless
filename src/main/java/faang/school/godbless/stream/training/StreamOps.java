package faang.school.godbless.stream.training;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamOps {

    public static int sumEven(List<Integer> nums) {
        return nums
                .stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> nums) {
        return nums.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static double findAverage(List<Integer> nums) {
        return nums
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWithSymbol(List<String> strings, String startingSymbol) {
        return strings
                .stream()
                .filter(handle -> handle.startsWith(startingSymbol))
                .count();
    }

    public static List<String> filterStringsWithSubstring(List<String> strings, String substring) {
        return strings
                .stream()
                .filter(string -> string.toLowerCase().contains(substring.toLowerCase()))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings
                .stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean areAllValid(List<String> strings, Predicate<String> condition) {
        return strings.stream().allMatch(condition);
    }

    public static int findSmallestNumberGreaterThan(List<Integer> nums, int inputNumber) {
        return nums
                .stream()
                .sorted(Comparator.naturalOrder())
                .filter(num -> num > inputNumber)
                .findFirst()
                .orElse(0);
    }

    public static List<Integer> transformStringsIntoLengths(List<String> strings) {
        return strings
                .stream()
                .map(String::length)
                .toList();

    }
}
