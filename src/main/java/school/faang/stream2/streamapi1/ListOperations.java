package school.faang.stream2.streamapi1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class ListOperations {
    public static Integer sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public static Integer findMax(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseGet(null);
    }

    public static Double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseGet(null);
    }

    public static Long countStringsStartingWith(List<String> strings, char a) {
        return strings.stream()
                .filter(str -> str.charAt(0) == a)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String an) {
        return strings.stream()
                .filter(str -> str.contains(an))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static <T> Boolean allMatchCondition(List<T> numbers, Predicate<T> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static Integer findMinGreaterThan(List<Integer> numbers, int i) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(n -> n > i)
                .min()
                .orElseGet(null);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
