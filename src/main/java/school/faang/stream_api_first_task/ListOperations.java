package school.faang.stream_api_first_task;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumEvenNums(List<Integer> nums) {
        return nums.stream().filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue).sum();
    }

    public static int findBiggestElement(List<Integer> nums) {
        return nums.stream().max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static double getAverage(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue)
                .average().orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static long findAmountOfStringsStartsWith(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> !string.isEmpty() && string
                .charAt(0) == symbol).count();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean isGreaterThanCertainElement(List<Integer> nums, Predicate<Integer> predicate) {
        return nums.stream().allMatch(predicate);
    }

    public static int findLowestElementAtList(List<Integer> nums, int num) {
        return nums.stream()
                .filter(n -> n > num)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("No elements greater than" + num));
    }

    public static List<Integer> transformStringsToLengths(List<String> nums) {
        return nums.stream().map(String::length).toList();
    }
}
