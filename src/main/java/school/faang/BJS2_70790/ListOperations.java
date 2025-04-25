package school.faang.BJS2_70790;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("the list is empty"));
    }

    public static double findAverage(List<Integer> number) {
        return number.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("the list is empty"));
    }

    public static long countStringsStartingWith(List<String> strings, char firstLetter) {
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(firstLetter)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substrings) {
        return strings.stream()
                .filter(str -> str.contains(substrings))
                .toList();
    }

    public static List<String> sortByLenght(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(n -> n > threshold)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("there is no such element in collection"));
    }

    public static List<Integer> confertToLenghts(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}


