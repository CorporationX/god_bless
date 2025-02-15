package school.faang.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> nums) {

        return nums.stream().filter((x -> (x % 2 == 0)))
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> nums) {

        return nums.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст!"));
    }

    public static double findAverage(List<Integer> nums) {

        return nums.stream()
                .mapToInt(Integer::intValue)
                .average().orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> strings, char c) {
        return strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == c)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {

        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> nums, Predicate<Integer> predicate) {
        return nums.stream().allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> nums, int target) {
        return nums.stream()
                .filter(num -> num > target)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("нет элемента больше " + target));
    }

    public static List<Integer> convertToLengths(List<String> strings) {

        return strings.stream()
                .map(String::length)
                .toList();
    }
}