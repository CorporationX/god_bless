package ru.kraiush.BJS2_35612;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, (a, b) -> a + b);
    }

    public static int findMax(List<Integer> nums) {
        return nums.stream()
                .max((a, b) -> a - b)
                .orElseThrow(() -> new NoSuchElementException("The list is empty"));
    }

    public static double findAverage(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> strings, char c) {
        return (int) strings.stream()
                .filter(s -> s.startsWith(String.valueOf(c)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((str1, str2) -> str1.length() - str2.length())
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> nums, Predicate<Integer> predicate) {
        return nums.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> nums, int num) {
        return nums.stream()
                .filter(n -> n > num)
                .sorted()
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("There is no number greater than given number: " + num));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(s -> s.length())
                .toList();
    }
}
