package school.faang.streamapi1;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class StaticMethods {
    public static int sumEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, (num1, num2) -> num1 + num2);
    }

    public static int maxValue(List<Integer> numbers) {
        return numbers.stream()
                .max((num1, num2) -> num1 - num2)
                .orElseThrow(NoSuchElementException::new);
    }

    public static double averageValue(List<Integer> numbers) {
        int average = numbers.stream()
                .reduce(0, Integer::sum);
        return (double) average / numbers.size();
    }

    public static long stringsNumber(List<String> strings, char character) {
        return (long) strings.stream()
                .filter(list -> list.startsWith(String.valueOf(character)))
                .count();
    }

    public static List<String> substringFinder(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> stringsSorter(List<String> strings) {
        return strings.stream()
                .sorted((string1, string2) -> string1.length() - string2.length()).toList();
    }

    public static boolean predicateChecker(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static int minValue(List<Integer> numbers, int value) {
        return numbers.stream().filter(number -> number > value)
                .min((num1, num2) -> num1 - num2)
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<Integer> toStringLength(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }
}
