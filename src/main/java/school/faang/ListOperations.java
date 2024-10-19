package school.faang;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        int sumOfEven = numbers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
        return sumOfEven;
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer::max)
                .get();
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(x -> x)
                .average()
                .orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> strings, char key) {
        return (int) strings.stream()
                .filter(s -> s.startsWith(String.valueOf(key)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String key) {
        return strings.stream()
                .filter(s -> s.contains(key))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> key) {
        return numbers.stream()
                .allMatch(key);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream()
                .filter(n -> n > number)
                .min(Integer::compare)
                .orElseThrow(NoSuchElementException::new);
    }

    public static List<Integer> convertToLengths(List<String> strings){
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
