package school.faang.bjs2_58360;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список элементов пуст"));
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStringsStartingWith(List<String> strings, char character) {
        return strings.stream()
                .filter(s -> s.startsWith(character + ""))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String str) {
        return strings.stream()
                .filter(s -> s.contains(str))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream()
                .allMatch(filter);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int number) {
        return numbers.stream()
                .sorted(Comparator.naturalOrder())
                .filter(num -> num > number)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("В списке нет элементов больше числа: " + number));
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .mapToInt(String::length)
                .boxed()
                .collect(Collectors.toList());
    }

}
