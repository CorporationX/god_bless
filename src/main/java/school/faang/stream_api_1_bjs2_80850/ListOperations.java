package school.faang.stream_api_1_bjs2_80850;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListOperations {
    public static Integer sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().filter(n -> n % 2 == 0).reduce(0, (c1, c2) -> c1 + c2);
    }

    public static Integer findMax(List<Integer> numbers) {
        return numbers.stream().reduce(Integer.MIN_VALUE, (a, b) -> a > b ? a : b);
    }

    public static OptionalDouble findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average();
    }

    public static long countStringsStartingWith(List<String> strings, Character ch) {
        return strings.stream().filter(s -> s.startsWith(ch.toString())).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String subString) {
        return strings.stream().filter(s -> s.contains(subString)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream().allMatch(predicate);
    }

    public static Optional<Integer> findMinGreaterThan(List<Integer> numbers, Integer border) {
        return numbers.stream().filter(n -> n > border).min(Integer::compareTo);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().map(String::length).collect(Collectors.toList());
    }
}
