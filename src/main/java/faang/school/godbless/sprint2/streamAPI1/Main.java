package faang.school.godbless.sprint2.streamAPI1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static double average(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static long stringsStartWith(List<String> strings, char first) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(first)))
                .count();
    }

    public static List<String> containsSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortedByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static <T> boolean allMatchByPredicate(List<T> list, Predicate<T> predicate) {
        return list.stream().allMatch(predicate);
    }

    public static int minNumberThatLargerThanNumber(List<Integer> numbers, int number) {
        return numbers.stream()
                .filter(numb -> numb > number)
                .min(Integer::compareTo)
                .orElse(Integer.MAX_VALUE);
    }

    public static List<Integer> stringLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

}
