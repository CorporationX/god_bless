package school.faang.sprint_2.task_46865;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(n -> n)
                .filter(n -> n % 2 == 0)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(n -> n)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("List is empty"));
    }


    public static int countStringsStartingWith(List<String> strings, char startChar) {
        return (int) strings.stream()
                .filter(s -> s.startsWith(String.valueOf(startChar)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String stringPart) {
        return strings.stream()
                .filter(string -> string.contains(stringPart))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int startSearchingMin) {
        return numbers.stream()
                .filter(integer -> integer > startSearchingMin)
                .min(Integer::compareTo)
                .orElseThrow(NoSuchElementException::new);
    }


    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
