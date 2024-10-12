package school.faang.streamapi1;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> strings = Arrays.asList("The", "Apple", "Long", "Rectangle", "Table");
        Predicate<Integer> predicate = number -> number > 0;

        System.out.println(sumOfEvenNumbers(integers));
        System.out.println(maxInteger(integers));
        System.out.println(findAverage(integers));
        System.out.println(countStringsStartingWith(strings, 'T'));
        System.out.println(stringContainsSubstring(strings, "le"));
        System.out.println(allMatchCondition(integers, predicate));
        System.out.println(findMinGreaterThan(integers, 3));
        System.out.println(mapToLengths(strings));

    }

    public static int sumOfEvenNumbers(List<Integer> integers) {
        return integers.stream()
                .filter(x -> x % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int maxInteger(List<Integer> integers) {
        return integers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Список пуст."));
    }

    public static double findAverage(List<Integer> integers) {
        return integers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public static int countStringsStartingWith(List<String> strings, char c) {
        return (int) strings.stream()
                .filter(s -> !s.isEmpty() && s.charAt(0) == c)
                .count();
    }

    public static List<String> stringContainsSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int threshold) {
        return numbers.stream()
                .filter(x -> x > threshold)
                .min(Integer::compareTo)
                .orElseThrow(() -> new NoSuchElementException("Нет элементов больше " + threshold));
    }

    public static List<Integer> mapToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
