package school.faang.bsj2_89333;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamApiTrainer {
    public static int getEvenDigitsSum(List<Integer> numbers) {
        return numbers
                .stream()
                .filter(integer -> integer % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int getMaxValue(List<Integer> values) {
        return values
                .stream()
                .max(Comparator.comparingInt(value -> value))
                .orElseThrow(IllegalStateException::new);

    }

    public static double calculateAverageValue(List<Integer> integers) {
        return (double) integers
                .stream()
                .reduce(0, Integer::sum) / integers.size();
    }

    public static long countStringsStartsWith(List<String> strings, char symbol) {
        return strings
                .stream()
                .filter(string -> string.charAt(0) == symbol)
                .count();
    }

    public static List<String> getStringsContains(List<String> strings, String valueForCheck) {
        return strings
                .stream()
                .filter(string -> string.contains(valueForCheck))
                .toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings
                .stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean areAllElementsTrue(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers
                .stream()
                .allMatch(predicate);
    }

    public static int getMinValueWithCheck(List<Integer> integers, int checkValue) {
        return integers
                .stream()
                .filter(integer -> integer > checkValue)
                .min(Comparator.comparingInt(integer -> integer))
                .orElseThrow(IllegalStateException::new);
    }

    public static List<Integer> getStringLengths(List<String> strings) {
        return strings
                .stream()
                .map(String::length)
                .toList();
    }
}