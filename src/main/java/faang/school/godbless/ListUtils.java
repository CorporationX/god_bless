package faang.school.godbless;

import java.util.*;
import java.util.stream.Collectors;

public class ListUtils {
    public static int sumEvenNumbers(List<Integer> numbers){
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers){
        return numbers.stream()
                .max(Integer::compare)
                .orElseThrow(() ->new IllegalArgumentException("List is empty"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static long countStringsStartingWith(List<String> strings, char character){
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(character)))
                .count();
    }

    public static List<String> filterStringsContaining(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());
    }

    public static boolean allMatch(List<Integer> numbers, java.util.function.Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n > threshold)
                .min(Integer::compare)
                .orElseThrow(() -> new IllegalArgumentException("No element greater than threshold"));
    }

    public static List<Integer> convertStringsToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
