package faang.school.godbless.sprint2.trainStreamAPI;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Predicate;

public class Main {
    public static int sumOfEvenNumbers(List<Integer> ints) {
        return ints.stream().filter(value -> value % 2 == 0)
                .reduce(Integer::sum).get();
    }

    public static OptionalInt maxIntInList(List<Integer> ints) {
        return ints.stream().mapToInt(Integer::intValue).max();
    }

    public static OptionalDouble averageValue(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average();
    }

    public static long countStringsStartingWith(List<String> strings, char chars) {
        return strings.stream().filter(s -> s.charAt(0) == chars).count();
    }

    public static List<String> filterBySubstring(List<String> strings, String substring) {
        return strings.stream().filter(s -> s.contains(substring)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatch(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream().allMatch(condition);
    }

    public static Optional<Integer> smallestElement(List<Integer> numbers, int ints) {
        return numbers.stream().filter(n -> n > ints).min(Integer::compareTo);
    }

    public static List<Integer> convertToLength(List<String> strings) {
        return strings.stream().map(String::length).toList();
    }

}
