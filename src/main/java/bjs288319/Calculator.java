package bjs288319;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Calculator {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return (int) numbers.stream()
                .filter(number -> number % 2 == 0)
                .count();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("the list is empty"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average()
                .orElse(0.0);
    }

    public static long findStringAmountsStartsWith(List<String> strs, char ch) {
        return strs.stream()
                .filter(str -> !str.isEmpty() && str.charAt(0) == ch)
                .count();
    }

    public static List<String> findStringsHasSubstring(List<String> strs, String str) {
        return strs.stream()
                .filter(newStr -> newStr.contains(str))
                .toList();
    }

    public static List<String> sortStringsPerLength(List<String> strs) {
        return strs.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean checkNums(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream()
                .allMatch(filter);
    }

    public static int findMinNumBiggerThan(List<Integer> numbers, int num) {
        return numbers.stream()
                .filter(number -> number > num)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("There is no appropriate"));
    }

    public static List<Integer> transformStringsIntoLengths(List<String> strs) {
        return strs.stream()
                .map(String::length)
                .toList();
    }
}
