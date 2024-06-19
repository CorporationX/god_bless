package faang.school.godbless.BJS210555;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class StreamMethods {
    public static int getSumEven(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int getMax(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("List can't be empty"));
    }

    public static double getAverage(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List can't be empty"));
    }

    public static int countStringsStartedWith(List<String> strings, String startsWith) {
        return (int) strings.stream()
                .filter(s -> s.startsWith(startsWith))
                .count();
    }

    public static List<String> filterStringsContainsOf(List<String> strings, String containsString) {
        return strings.stream()
                .filter(s -> s.contains(containsString))
                .toList();
    }

    public static List<String> sortStringsBySize(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean isStringLengthMoreThen(List<String> strings, int length) {
        return strings.stream()
                .allMatch(string -> string.length() > length);
    }

    public static int getMinMoreThen(List<Integer> nums, int number) {
        return nums.stream()
                .filter(n -> n > number)
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new NoSuchElementException("Not fond element more then" + number));
    }

    public static List<Integer> getStringsLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

}
