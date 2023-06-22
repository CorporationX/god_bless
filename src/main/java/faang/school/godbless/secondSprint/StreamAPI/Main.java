package faang.school.godbless.secondSprint.StreamAPI;

import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static int findSumEvenNumbers(List<Integer> nums) {
        return nums.stream()
                .filter(num -> num % 2 == 0)
                .reduce(Integer::sum)
                .orElse(0);
    }

    public static int findMaxNum(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Empty list"));
    }

    public static double findAverage(List<Integer> nums) {
        return nums.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Empty list"));
    }

    public static int findStringsCount(List<String> strings, char symbol) {
        return (int) strings.stream()
                .filter(string -> string.charAt(0) == symbol)
                .count();
    }

    public static List<String> findCorrectStrings(List<String> strings, String subString) {
        return strings.stream()
                .filter(string -> string.contains(subString))
                .toList();
    }

    public static List<String> sortListByStringLength(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> s2.length() - s1.length())
                .toList();
    }

    public static <T> boolean checkAllMatch(List<T> list, Predicate<T> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static int findCorrectNum(List<Integer> nums, int number) {
        return nums.stream()
                .filter(num -> num > number)
                .mapToInt(Integer::intValue)
                .min()
                .orElse(0);
    }

    public static List<Integer> convertStringToItsLength(List<String> strings) {
        return strings.stream()
                .mapToInt(String::length)
                .boxed()
                .toList();
    }
}
