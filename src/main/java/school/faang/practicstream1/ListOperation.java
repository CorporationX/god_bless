package school.faang.practicstream1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperation {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(num -> (num % 2 == 0))
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMaxElement(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Нет элементов в списке"));
    }

    public static double findAverageValue(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Нет элементов в списке"));
    }

    public static long countStringStartWithChar(List<String> strings, char symbol) {
        return strings.stream()
                .filter(str -> !str.isEmpty() && str.charAt(0) == symbol)
                .count();
    }

    public static List<String> filterSubstring(List<String> strings, String subString) {
        return strings.stream()
                .filter(str -> str.contains(subString))
                .toList();
    }

    public static List<String> sortedStringsByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static boolean checkCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMixElementAndMoreValue(List<Integer> numbers, int value) {
        return numbers.stream()
                .filter(num -> num > value)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Нету элементов в таблице"));
    }

    public static List<Integer> transformationStringToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}