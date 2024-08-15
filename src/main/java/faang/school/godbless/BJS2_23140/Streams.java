package faang.school.godbless.BJS2_23140;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Streams {

    public static int sumEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int max(List<Integer> nums) {
        return nums.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow();
    }

    public static double average(List<Integer> nums) {
        return nums.stream()
                .mapToInt(i -> i)
                .average()
                .orElseThrow();
    }

    public static long findNumberStartingWithCertainCharacter(List<String> strings, char target) {
        return strings.stream()
                .mapToInt(string -> string.charAt(0))
                .filter(ch -> ch == target)
                .count();
    }

    public static List<String> filterBySubstring(List<String> strings, CharSequence targetSubstring) {
        return strings.stream()
                .filter(string -> string.contains(targetSubstring))
                .toList();
    }

    public static void sortByLengthString(List<String> strings) {
        strings.sort(Comparator.comparing(String::length));
    }

    public static boolean isAllMatches(List<String> strings, Predicate<String> condition) {
        return strings.stream()
                .allMatch(condition);
    }

    public static int findMinNumberThanTarget(List<Integer> nums, int target) {
        return nums.stream()
                .filter(num -> num > target)
                .findFirst()
                .orElseThrow();
    }

    public static List<Integer> stringsToLengthStrings(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
