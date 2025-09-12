package school.faang.bjs2_88091;

import lombok.NonNull;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListOperations {

    public static Integer sumOfEvenNumbers(List<Integer> numbers) {
        testedOnNullListInt(numbers);
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Integer findMax(List<Integer> numbers) {
        testedOnNullListInt(numbers);
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static Double findAverage(List<Integer> numbers) {
        testedOnNullListInt(numbers);
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElseThrow(() -> new IllegalArgumentException("Список пуст"));
    }

    public static Long countStringsStartingWith(List<String> strings, char c) {
        testedOnNullStringInt(strings);
        return strings.stream()
                .filter(str -> str.startsWith(String.valueOf(c), 0))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        testedOnNullStringInt(strings);
        return strings.stream()
                .filter(str -> str != null && str.contains(substring))
                .collect(Collectors.toList());
    }

    public static List<String> sortByLength(List<String> strings) {
        testedOnNullStringInt(strings);
        return strings.stream()
                .sorted()
                .toList();

    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        testedOnNullListInt(numbers);
        return numbers.stream()
                .allMatch(predicate);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int num) {
        testedOnNullListInt(numbers);
        return numbers.stream()
                .filter(n -> n > num)
                .min(Integer::compare)
                .orElseThrow();
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        testedOnNullStringInt(strings);
        return strings.stream()
                .map(String::length)
                .toList();
    }

    private static void testedOnNullListInt(List<Integer> list) {
        if (Objects.isNull(list)) {
            throw new IllegalArgumentException("Список и подстрока не могут быть null");
        }
    }

    private static void testedOnNullStringInt(List<String> list) {
        if (Objects.isNull(list)) {
            throw new IllegalArgumentException("Список и подстрока не могут быть null");
        }
    }
}

