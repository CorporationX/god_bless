package school.faang.bjs2_88108;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Predicate;

public class ListOperations {
    private ListOperations() {
    }

    public static int findSumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMaxNumber(List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new NoSuchElementException(
                        "все числа из списка были null"
                ));
    }

    public static double findAverageValue(List<Integer> numbers) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException(
                        "нельзя найти среднее арифметическое - все числа из списка были null"
                ));
    }

    public static int findMinGreaterThan(List<Integer> numbers, int comparingNumber) {
        return numbers.stream()
                .filter(Objects::nonNull)
                .filter(number -> number > comparingNumber)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException(
                        "нельзя найти минимальное число, которое больше указанного - все числа из списка были null"
                ));
    }

    public static long countStringsContainingChar(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.startsWith(Character.toString(symbol)))
                .count();
    }

    public static List<String> findStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean areAllStringsEqual(List<String> numbers, Predicate<String> condition) {
        return numbers.stream().allMatch(condition);
    }

    public static List<Integer> turnToLengthSize(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
