package bjs2_35550;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Solution {
    public static int getSumOfEvenNum(List<Integer> nums) {
        return nums
                .stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int getMaxNum(List<Integer> nums) {
        return nums
                .stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new NoSuchElementException("You probably gave an empty list"));
    }

    public static double getAverageValue(List<Integer> nums) {
        return nums
                .stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("You probably gave an empty list"));
    }

    public static int getCountOFStringsStartsWith(List<String> strings, char c) {
        return (int) strings
                .stream()
                .filter(string -> string.startsWith(Character.toString(c)))
                .count();
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings
                .stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings
                .stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean isAllMatch(List<Integer> nums, Predicate<Integer> predicate) {
        return nums
                .stream()
                .allMatch(predicate);
    }

    public static int getMinGreaterThan(List<Integer> nums, int number) {
        return nums
                .stream()
                .filter(num -> num > number)
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(() -> new NoSuchElementException("The number is too big or probably list is empty"));
    }

    public static List<Integer> mapStringToLength(List<String> strings) {
        return strings
                .stream()
                .map(String::length)
                .toList();
    }
}
