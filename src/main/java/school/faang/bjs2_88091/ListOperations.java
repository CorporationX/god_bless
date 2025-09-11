package school.faang.bjs2_88091;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOperations {

    public static Integer sumOfEvenNumbers(List<Integer> numbers) {

        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Integer findMax(List<Integer> numbers) {

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static Double findAverage(List<Integer> numbers) {

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static Long countStringsStartingWith(List<String> strings, char c) {

        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(c), 0))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        if (strings == null || substring == null) {
            throw new IllegalArgumentException("Список и подстрока не могут быть null");
        }
        return strings.stream()
                .filter(str -> str != null && str.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException("Список не может быть null");
        }

        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .collect(Collectors.toList());

    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {

        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int num) {

        return numbers.stream()
                .filter(n -> n > num)
                .min(Integer::compare)
                .orElseThrow();
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream().flatMapToInt(str -> IntStream.of(str.length())).boxed().toList();
    }


}
