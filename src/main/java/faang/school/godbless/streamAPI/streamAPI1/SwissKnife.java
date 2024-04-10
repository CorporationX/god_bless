package faang.school.godbless.streamAPI.streamAPI1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SwissKnife {
    public static int getEvenNumsSum(List<Integer> nums) {
        if (nums == null) {
            return 0;
        }

        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Optional<Integer> getMax(List<Integer> nums) {
        if (nums == null) {
            return Optional.of(0);
        }

        return nums.stream().max(Integer::compareTo);
    }

    public static int getMeanNum(List<Integer> nums) {
        if (nums == null) {
            return 0;
        }

        return nums.stream()
                .reduce(0, Integer::sum) / nums.size();
    }

    public static long getStringsNumBeginWith(List<String> strings, char symbol) {
        if (strings == null) {
            return 0;
        }

        return strings.stream().filter(string -> string.matches(symbol + ".*")).count();
    }

    public static List<String> filterStringsByContainingSubstring(List<String> strings, String substring) {
        if (strings == null) {
            return new ArrayList<>();
        }

        return strings.stream().filter(string -> string.contains(substring)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        if (strings == null) {
            return new ArrayList<>();
        }

        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static <T> boolean satisfiesCondition(List<T> list, Predicate<T> condition) {
        if (list == null || condition == null) {
            return false;
        }

        return list.stream().allMatch(condition);
    }

    public static Optional<Integer> getMinBiggerThan(List<Integer> nums, int biggerThanThis) {
        if (nums == null) {
            return Optional.of(0);
        }

        return nums.stream()
                .filter(num -> num > biggerThanThis)
                .min(Integer::compareTo);
    }

    public static List<Integer> stringsToLengths(List<String> strings) {
        if (strings == null) {
            return new ArrayList<>();
        }

        return strings.stream().map(String::length).toList();
    }
}
