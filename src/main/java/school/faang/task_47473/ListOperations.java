package school.faang.task_47473;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ListOperations {
    
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(num -> num)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(number -> number)
                .average()
                .orElseThrow(NoSuchElementException::new);
    }

    public static int countStringsStartingWith(List<String> strings, char a) {
        return strings.stream()
                .filter(string -> string.startsWith(Character.toString(a)))
                .toList()
                .size();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String an) {
        return strings.stream()
                .filter(string -> string.contains(an))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int i) {
        return numbers.stream()
                .filter(number -> number > i)
                .mapToInt(number -> number)
                .min()
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .mapToInt(String::length)
                .boxed()
                .toList();
    }
}
