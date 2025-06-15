package school.faang.bjs2_80822;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOfOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxNumber(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("не найдены элементы в списке"));
    }

    public static double averageOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long amountStringStartWith(List<String> strings, char c) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(c)))
                .count();
    }

    public static List<String> stringWith(List<String> strings, String str) {
        return strings.stream()
                .filter(string -> string.contains(str))
                .toList();
    }

    public static List<String> filterStrings(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .anyMatch(condition);
    }

    public static int sumOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int minNumber(List<Integer> numbers, int num) {
        return numbers.stream()
                .filter(number -> number > num)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("нет элементов больше" + num));
    }

    public static List<Integer> mapToStringLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
