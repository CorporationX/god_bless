package listoperations;

import java.util.List;
import java.util.function.Predicate;
import lombok.experimental.UtilityClass;
import static java.util.Comparator.comparingInt;

@UtilityClass
public class ListOperations {

    private static final String ERR_NUMBERS_NULL = "List of numbers must not be null";
    private static final String ERR_NUMBERS_NULL_OR_EMPTY = "List of numbers must not be null or empty";
    private static final String ERR_STRINGS_NULL = "List of strings must not be null";
    private static final String ERR_SUBSTRING_NULL = "Substring must not be null";
    private static final String ERR_PREDICATE_NULL = "Predicate must not be null";
    private static final String ERR_NO_MAX = "No maximum element found";
    private static final String ERR_NO_ELEMENT_GREATER_THAN = "No element greater than ";

    public int sumOfEvenNumbers(List<Integer> numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException(ERR_NUMBERS_NULL);
        }
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int findMax(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(ERR_NUMBERS_NULL_OR_EMPTY);
        }
        return numbers.stream()
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ERR_NO_MAX));
    }

    public double findAverage(List<Integer> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException(ERR_NUMBERS_NULL_OR_EMPTY);
        }
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public long countStringsStartingWith(List<String> strings, char ch) {
        if (strings == null) {
            throw new IllegalArgumentException(ERR_STRINGS_NULL);
        }
        return strings.stream()
                .filter(s -> s != null && !s.isEmpty() && s.charAt(0) == ch)
                .count();
    }

    public List<String> filterStringsContainingSubstring(List<String> strings, String substring) {
        if (strings == null) {
            throw new IllegalArgumentException(ERR_STRINGS_NULL);
        }
        if (substring == null) {
            throw new IllegalArgumentException(ERR_SUBSTRING_NULL);
        }
        return strings.stream()
                .filter(s -> s != null && s.contains(substring))
                .toList();
    }

    public List<String> sortByLength(List<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException(ERR_STRINGS_NULL);
        }
        return strings.stream()
                .sorted(comparingInt(String::length))
                .toList();
    }

    public boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        if (numbers == null) {
            throw new IllegalArgumentException(ERR_NUMBERS_NULL);
        }
        if (predicate == null) {
            throw new IllegalArgumentException(ERR_PREDICATE_NULL);
        }
        return numbers.stream()
                .allMatch(predicate);
    }

    public int findMinGreaterThan(List<Integer> numbers, int threshold) {
        if (numbers == null) {
            throw new IllegalArgumentException(ERR_NUMBERS_NULL);
        }
        return numbers.stream()
                .filter(n -> n > threshold)
                .min(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(ERR_NO_ELEMENT_GREATER_THAN + threshold));
    }

    public List<Integer> convertToLengths(List<String> strings) {
        if (strings == null) {
            throw new IllegalArgumentException(ERR_STRINGS_NULL);
        }
        return strings.stream()
                .map(s -> s == null ? 0 : s.length())
                .toList();
    }
}
