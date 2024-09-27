package task11;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static int getSumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number)
                .sum();
    }

    public static int getMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .get();
    }

    public static double getAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(number -> number)
                .average()
                .orElse(Double.NaN);
    }

    public static long getCountOfSymbol(List<String> strings, char symbol) {
        return strings.stream()
                .filter(string -> string.charAt(0) == symbol)
                .count();
    }

    public static List<String> filterBySubstring(List<String> strings, String s) {
        return strings.stream()
                .filter(word -> word.contains(s))
                .toList();
    }

    public static List<String> filterByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .toList();
    }

    public static boolean isCondition(List<String> strings, int len) {
        long l = strings.stream()
                .filter(string -> string.length() == len)
                .count();
        return l == strings.size();
    }

    public static int getMinAfterCurrent(List<Integer> numbers, int current) {
        return numbers.stream()
                .filter(number -> number > current)
                .sorted()
                .findFirst()
                .get();
    }

    public static List<Integer> mapToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}