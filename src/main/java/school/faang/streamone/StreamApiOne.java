package school.faang.streamone;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamApiOne {
    public static int sumEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(y -> y % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxNumber(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .max()
                .getAsInt();
    }

    public static double avgNumbers(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .getAsDouble();
    }

    public static long countLines(List<String> list, char ch) {
        return list.stream()
                .filter(s -> s.startsWith(String.valueOf(ch)))
                .count();
    }

    public static List<String> searchLines(List<String> list, String str) {
        return list.stream()
                .filter(s -> s.contains(str))
                .collect(Collectors.toList());
    }

    public static List<String> sortedByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean isBoolean(List<String> list, char ch) {
        return list.stream()
                .allMatch(Predicate.isEqual(String.valueOf(ch)));
    }

    public static int minNumber(List<Integer> list, int number) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .filter(num -> num < number)
                .min()
                .getAsInt();
    }

    public static List<Integer> lengthLines(List<String> list) {
        return list.stream()
                .map(String::length)
                .toList();
    }
}