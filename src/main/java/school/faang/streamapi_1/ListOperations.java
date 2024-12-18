package school.faang.streamapi_1;

import java.util.*;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) throws Exception {
        if (numbers.isEmpty()) {
            throw new Exception("List is empty");
        }
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .mapToInt(number -> number).sum();
    }

    public static OptionalInt findMax(List<Integer> numbers) throws Exception {
        if (numbers.isEmpty()) {
            throw new Exception("List is empty");
        }
        return numbers.stream()
                .mapToInt(number -> number).max();
    }

    public static OptionalDouble findAverage(List<Integer> numbers) throws Exception {
        if (numbers.isEmpty()) {
            throw new Exception("List is empty");
        }
        return numbers.stream()
                .mapToInt(number -> number).average();
    }

    public static long countStringsStartingWith(List<String> strings, char symbol) throws Exception {
        if (strings.isEmpty()) {
            throw new Exception("List is empty");
        }
        return strings.stream()
                .filter(s -> s.startsWith(String.valueOf(symbol)))
                .count();
    }
    
    public static long filterStringsContainingSubstring(List<String> strings, String prefix) throws Exception {
        if (strings.isEmpty()) {
            throw new Exception("List is empty");
        }
        return strings.stream()
                .filter(s -> s.contains(prefix))
                .count();
    }

    public static List<String> sortByLength(List<String> strings) throws Exception {
        if (strings.isEmpty()) {
            throw new Exception("List is empty");
        }
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) throws Exception {
        if (numbers.isEmpty()) {
            throw new Exception("List is empty");
        }
        return numbers.stream()
                .allMatch(predicate);
    }

    public static OptionalInt findMinGreaterThan(List<Integer> numbers, Integer limit) throws Exception {
        if (numbers.isEmpty()) {
            throw new Exception("List is empty");
        }
        return numbers.stream()
                .filter(number -> number > limit)
                .mapToInt(number -> number).min();
    }

    public static List<Integer> convertToLengths(List<String> numbers) throws Exception {
        if (numbers.isEmpty()) {
            throw new Exception("List is empty");
        }
        return numbers.stream().map(String::length).toList();
    }

}
