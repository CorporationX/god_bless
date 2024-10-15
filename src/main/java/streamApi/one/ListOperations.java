package streamApi.one;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .peek(number -> System.out.println(number + " + "))
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseGet(() -> {
                    System.out.println("Список-то пуст!");
                    return 0;
                });
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> strings, char character) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(character)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> Integer.compare(s1.length(), s2.length()))
                .collect(Collectors.toList());
    }

    public static String allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        boolean result = numbers.stream()
                .allMatch(predicate);

        if (result) {
            return "Да, все числа чётные";
        } else {
            return "Нет, не все числа чётные";
        }
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(number -> number > threshold)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Элементов в списке, больше заданного значения нет"));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

}
