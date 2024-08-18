package faang.school.godbless.bjs2_23004;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    // 1
    public static int sumEvenNumbers1(int... numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    public static int sumEvenNumbers2(int[] numbers) {
        return Arrays.stream(numbers)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    public static int sumEvenNumbers3(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(n -> n)
                .sum();
    }

    // 2
    public static int maxElement(int[] numbers) {
        return Arrays.stream(numbers)
                .max()
                .orElse(0);
    }

    public static int maxElement(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElse(0);
    }

    // 3
    public static int average(int[] numbers) {
        return (int) Arrays.stream(numbers)
                .average()
                .orElse(0);
    }

    public static int average(List<Integer> numbers) {
        return (int) numbers.stream()
                .mapToInt(n -> n)
                .average()
                .orElse(0);
    }

    // 4
    public static int countStrings(String[] strings, String symbol) {
        return (int) Stream.of(strings)
                .filter(s -> s.startsWith(symbol))
                .count();
    }

    public static int countStrings(List<String> strings, String symbol) {
        return (int) strings.stream()
                .filter(s -> s.startsWith(symbol))
                .count();
    }

    // 5
    public static int containsSubstring(String[] strings, String sub) {
        return (int) Stream.of(strings)
                .filter(s -> s.contains(sub))
                .count();
    }

    public static int containsSubstring(List<String> strings, String sub) {
        return (int) strings.stream()
                .filter(s -> s.contains(sub))
                .count();
    }

    // 6
    public static List<String> sortByLength(String[] strings) {
        return Stream.of(strings)
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    // 7
    public static boolean matchAll(List<String> strings, String symbol) {
        return strings.stream()
                .allMatch(s -> s.contains(symbol));
    }

    // 8
    public static int findMin(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .mapToInt(n -> n)
                .filter(n -> n > threshold)
                .min()
                .orElse(0);
    }

    // 8
    public static List<Integer> convert(List<String> strings) {
        return strings.stream()
                .mapToInt(String::length)
                .boxed()
                .toList();
    }
}
