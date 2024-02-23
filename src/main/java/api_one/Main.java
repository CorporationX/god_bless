package api_one;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.Comparator.naturalOrder;

public class Main {
    public static int sumEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(numbers -> numbers % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static int findMax(List<Integer> list) {
        return list.stream()
                .max(naturalOrder())
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static double calculateAverage(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new NoSuchElementException("Список пуст"));
    }

    public static long countStartsWith(List<String> strings, String symbol) {
        Objects.requireNonNull(symbol, "not null");
        if (strings.isEmpty()) {
            return 0;
        }
        return strings.stream()
                .filter(s -> s.startsWith(symbol))
                .count();
    }
    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(comparingInt(String::length))
                .toList();
    }

    public static boolean allMatch(List<String> strings, Predicate<String> predicate) {
        return strings.stream().allMatch(predicate);
    }


    public static Optional<String> findLongestStringGreaterThan(List<String> strings, int targetLength) {
        return strings.stream()
                .filter(s -> s.length() > targetLength)
                .min(comparingInt(String::length))
                .or(Optional::empty);
    }

    public static List<Integer> getStringLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<String> strings = Arrays.asList("Java", "Python", "JavaScript", "C++", "Ruby");

        int sum = sumEvenNumbers(list);
        int max = findMax(list);
        OptionalDouble average = OptionalDouble.of(calculateAverage(list));
        long count = countStartsWith(strings, "J");
        List<String> sortedStrings = sortByLength(strings);
        boolean allMatch = allMatch(strings,s -> s.length() > 1);
        Optional<String> longestString = findLongestStringGreaterThan(strings, 5);
        List<Integer> lengths = getStringLengths(strings);

        System.out.println("Sum of even numbers: " + sum);
        System.out.println("Max number: " + max);
        System.out.println("Average: " + average.orElse(0.0));
        System.out.println("Count of strings starting with J: " + count);
        System.out.println("Sorted strings: " + sortedStrings);
        System.out.println("All strings longer than 1 character: " + allMatch);
        System.out.println("Longest string longer than 5 characters: " + longestString.orElse("None"));
        System.out.println("Lengths of strings: " + lengths);
    }
}
