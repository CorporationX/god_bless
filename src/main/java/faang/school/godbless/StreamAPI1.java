package faang.school.godbless;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class StreamAPI1 {
    public int findSum(List<Integer> numbers) {
        return numbers.stream().reduce(0, Integer::sum);
    }

    public Optional<Integer> findMax(List<Integer> numbers) {
        return numbers.stream().max(Integer::compare);
    }

    public OptionalDouble findAverage(List<Integer> numbers) {
        return numbers.stream().mapToInt(Integer::intValue).average();
    }

    public long countRows(List<String> rows, char firstSymbol) {
        return rows.stream().filter(row -> row.charAt(0) == firstSymbol).count();
    }

    public List<String> filterContainsSubRow(List<String> rows, String subRow) {
        return rows.stream().filter(row -> row.contains(subRow)).toList();
    }

    public List<String> sortRowsByLength(List<String> rows) {
        return rows.stream().sorted(Comparator.comparing(String::length).reversed()).toList();
    }

    public <T> boolean allMatch(List<T> rows, Predicate<T> checker) {
        return rows.stream().allMatch(checker);
    }

    public Optional<Integer> minWithCheck(List<Integer> nums, int minBorder) {
        return nums.stream().filter(integer -> integer > minBorder)
                .min((a,b) -> a < b ? a : b);
    }

    public List<Integer> rowsToLength(List<String> rows) {
        return rows.stream().map(String::length).toList();
    }
}
