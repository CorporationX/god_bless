package faang.school.godbless.letspracticestreamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class ListUtils {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(n -> n)
                .average()
                .orElseThrow(() -> new NoSuchElementException("List is empty"));
    }

    public static long countStringsStartingWith(List<String> stringList, char letter) {
        return stringList.stream()
                .filter(s -> s.startsWith(String.valueOf(letter)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> stringList, String substring) {
        return stringList.stream()
                .filter(s -> s.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> stringList) {
        return stringList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .allMatch(num -> num > threshold);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(num -> num > threshold)
                .min(Integer::compare)
                .orElseThrow(() -> new NoSuchElementException("No element greater than " + threshold));
    }

    public static List<Integer> transformStringsToLengths(List<String> stringList) {
        return stringList.stream()
                .map(String::length)
                .toList();
    }
}