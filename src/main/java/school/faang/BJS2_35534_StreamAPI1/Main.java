package school.faang.BJS2_35534_StreamAPI1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class Main {
    public static int evenNumbersSum(List<Integer> numbers) {
        ValidationUtils.validateNotNullOrEmpty(numbers);

        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int listMaxValue(List<Integer> numbers) {
        ValidationUtils.validateNotNullOrEmpty(numbers);

        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("List does not contain any valid maximum value"));
    }

    public static double listAverageValue(List<Integer> numbers) {
        ValidationUtils.validateNotNullOrEmpty(numbers);

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalStateException("Unable to calculate average list value!"));
    }

    public static int countStringsStartingWith(List<String> list, char ch) {
        ValidationUtils.validateNotNull(list);

        return (int)list.stream()
                .filter(string -> string.startsWith(String.valueOf(ch)))
                .count();
    }

    public static List<String> stringsContainingSubstring(List<String> list, String substring) {
        ValidationUtils.validateNotNull(list);
        ValidationUtils.validateString(substring, "Substring can't be null or blank!");

        return list.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> list) {
        ValidationUtils.validateNotNull(list);

        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allElementsMatch(List<Integer> numbers, Predicate<Integer> condition) {
        ValidationUtils.validateNotNull(numbers);

        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int ceiling) {
        ValidationUtils.validateNotNullOrEmpty(numbers);

        return numbers.stream()
                .filter(number -> number > ceiling)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("List does not contain any valid value for given condition"));
    }

    public static List<Integer> getStringsLengths(List<String> list) {
        ValidationUtils.validateNotNull(list);

        return list.stream()
                .map(String::length)
                .toList();
    }
}
