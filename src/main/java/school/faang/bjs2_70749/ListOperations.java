package school.faang.bjs2_70749;

import lombok.experimental.UtilityClass;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

@UtilityClass
public class ListOperations {
    public int sumOfEvenNumbers(List<Integer> integers) {
        return integers.stream()
                .filter(Objects::nonNull)
                .filter(value -> Objects.equals(value % 2, 0))
                .mapToInt(Integer::intValue)
                .sum();

    }

    public int findMax(List<Integer> integers) {
        return integers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .max().orElseThrow(ValueNotFoundException::new);

    }

    public double findAverage(List<Integer> integers) {
        return integers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .average().orElseThrow(ValueNotFoundException::new);

    }

    public long countStringsStartingWith(List<String> strings, char ch) {
        String prefix = String.valueOf(ch).toLowerCase();
        return strings.stream()
                .filter(Objects::nonNull)
                .filter(str -> !str.isBlank())
                .map(String::trim)
                .filter(str -> str.toLowerCase().startsWith(prefix))
                .count();
    }

    public List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(Objects::nonNull)
                .filter(str -> str.contains(substring))
                .toList();
    }

    public List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.nullsLast(Comparator.comparingInt(String::length)))
                .toList();
    }

    public boolean allMatchCondition(List<Integer> integers, Predicate<Integer> condition) {
        return integers.stream()
                .allMatch(condition);
    }

    public int findMinGreaterThan(List<Integer> integers, int minValue) {
        return integers.stream()
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .filter(value -> value > minValue)
                .min().orElseThrow(ValueNotFoundException::new);
    }

    public List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(str -> Objects.isNull(str) ? 0 : str.length())
                .toList();
    }
}
