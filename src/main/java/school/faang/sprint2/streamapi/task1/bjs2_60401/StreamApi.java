package school.faang.sprint2.streamapi.task1.bjs2_60401;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApi {
    public int findEvenNumbersSum(List<Integer> integers) {
        return integers.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();
    }

    public static int findMaxNumber(List<Integer> integers) {
        return integers.stream().mapToInt(Integer::intValue).max()
                .orElseThrow(() -> new IllegalArgumentException("The list of integers is empty"));
    }

    public static double findAverage(List<Integer> integers) {
        return integers.stream().mapToInt(Integer::intValue).average()
                .orElseThrow(() -> new IllegalArgumentException("The list of integers is empty"));
    }

    public static long findNumberOfStringsStartWith(List<String> strings, char character) {
        return strings.stream().filter(s -> s != null).filter(s -> s.startsWith(String.valueOf(character))).count();
    }

    public static List<String> filterStringContainSubstring(List<String> strings, String string) {
        return strings.stream().filter(s -> s.contains(string)).collect(Collectors.toList());
    }

    public static List<String> sortByStringLength(List<String> strings) {
        return strings.stream().sorted((x, y) -> x.length() - y.length()).collect(Collectors.toList());
    }

    public static boolean checkCondition(List<Integer> integers, Predicate<Integer> condition) {
        return integers.stream().allMatch(condition);
    }

    public static int findMinAboveThreshold(List<Integer> integers, int threshold) {
        return integers.stream().filter(num -> num > threshold).mapToInt(Integer::intValue).min()
                .orElseThrow(() -> new NoSuchElementException("There is no element greater threshold"));
    }

    public static List<Integer> convertStringToLengths(List<String> strings) {
        return strings.stream().map(String::length).collect(Collectors.toList());
    }
}
