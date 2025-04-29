package school.faang.stream_api.bjs2_70827.stream_api1;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> num % 2 == 0)
                .reduce(0, (acc, num) -> acc + num);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(() ->
                        new NoSuchElementException("There is impossible to find max element. List is empty"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() ->
                        new NoSuchElementException("There is impossible to find average. List is empty"));
    }

    public static long countStringsStartingWith(List<String> strings, char startingWith) {
        return strings.stream()
                .filter(str -> !str.isEmpty() && str.startsWith(String.valueOf(startingWith)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String subString) {
        return strings.stream()
                .filter(str -> str.contains(subString))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted((s1, s2) -> s1.length() - s2.length())
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream()
                .filter(num -> num > number)
                .min(Comparator.naturalOrder())
                .orElseThrow(() ->
                        new NoSuchElementException("There is impossible to find min greater than %d. List is empty"
                                .formatted(number)));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }

}
