package faang.school.godbless.BJS2_23043;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamPractice {
    public static int findSumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxElement(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        var v = numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        return Math.round(v * 100.0) / 100.0;
    }

    public static int getStringsCount(List<String> strings, char start) {
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(start)))
                .toList()
                .size();
    }

    public static List<String> getSubstrings(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkElements(List<String> numbers, Predicate<String> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findLessThen(List<Integer> numbers, int then) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num > then)
                .min()
                .orElse(0);
    }

    public static List<Integer> mapStringsToTheirLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}