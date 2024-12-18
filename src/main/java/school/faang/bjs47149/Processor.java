package school.faang.bjs47149;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Processor {
    public static int sumEven(List<Integer> numbers) {
        return numbers.stream()
                .filter(number -> number % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static int max(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compare)
                .orElse(Integer.MIN_VALUE);
    }

    public static double avg(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new RuntimeException("no numbers"));
    }

    public static long countStartingWithChar(List<String> strings, char a) {
        return strings.stream()
                .filter(string -> string.startsWith(String.valueOf(a)))
                .count();
    }

    public static List<String> filterStrings(List<String> strings, String substring) {
        return strings.stream()
                .filter(string -> string.contains(substring))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean checkAllMatch(List<Integer> integers, Predicate<Integer> condition) {
        return integers.stream()
                .allMatch(condition);
    }

    public static Optional<Integer> minimalMore(List<Integer> numbers, int base) {
        return numbers.stream()
                .filter(number -> number > base)
                .min(Integer::compareTo);
    }

    public static List<Integer> mapStringsToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
