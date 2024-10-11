package school.faang.BJS2_35534_StreamAPI1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        ValidationUtils.validateNotNullOrEmpty(numbers);

        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        ValidationUtils.validateNotNullOrEmpty(numbers);

        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("List does not contain any valid maximum value"));
    }

    public static double findAverage(List<Integer> numbers) {
        ValidationUtils.validateNotNullOrEmpty(numbers);

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalStateException("Unable to calculate average list value!"));
    }

    public static int countStringsStartingWith(List<String> wordsList, char firstChar) {
        ValidationUtils.validateNotNull(wordsList);

        return (int)wordsList.stream()
                .filter(string -> string.startsWith(String.valueOf(firstChar)))
                .count();
    }

    public static List<String> stringsContainingSubstring(List<String> wordsList, String substring) {
        ValidationUtils.validateNotNull(wordsList);
        ValidationUtils.validateString(substring, "Substring can't be null or blank!");

        return wordsList.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> wordsList) {
        ValidationUtils.validateNotNull(wordsList);

        return wordsList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        ValidationUtils.validateNotNull(numbers);

        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int lowerBound) {
        ValidationUtils.validateNotNullOrEmpty(numbers);

        return numbers.stream()
                .filter(number -> number > lowerBound)
                .min(Comparator.naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("List does not contain any valid value for given condition"));
    }

    public static List<Integer> getStringsLengths(List<String> wordsList) {
        ValidationUtils.validateNotNull(wordsList);

        return wordsList.stream()
                .map(String::length)
                .toList();
    }
}
