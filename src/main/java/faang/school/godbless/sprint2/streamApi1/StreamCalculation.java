package faang.school.godbless.sprint2.streamApi1;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamCalculation {

    public static int calculateSumOfOrphan(List<Integer> nums) throws IllegalArgumentException{
        if (!isValidCollection(nums)) {
            throw new IllegalArgumentException("Incorrect list of numbers");
        }

        return nums.stream()
                .filter(Objects::nonNull)
                .filter(num -> num % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Optional<Integer> getMaxNUmber(List<Integer> nums) throws IllegalArgumentException{
        if (!isValidCollection(nums)) {
            throw new IllegalArgumentException("Incorrect list of numbers");
        }

        return nums.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(num -> num));
    }

    public static OptionalDouble getAverageValue(List<Integer> nums) {
        if (!isValidCollection(nums)) {
            throw new IllegalArgumentException("Incorrect list of numbers");
        }

        return nums.stream()
                .filter(Objects::nonNull)
                .mapToInt(num -> num)
                .average();
    }

    public static Long getCountStringsStartsFromSymbol(List<String> strings, String symbol) throws IllegalArgumentException {
        if (!isValidCollection(strings) || symbol == null) {
            throw new IllegalArgumentException("Incorrect paramethers");
        }

        return strings.stream()
                .filter(Objects::nonNull)
                .filter(string -> string.startsWith(symbol))
                .count();
    }

    public static List<String> getSortedStringsBySubstring(List<String> strings, String substring) {
        if (!isValidCollection(strings) || substring == null) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        return strings.stream()
                .filter(Objects::nonNull)
                .filter(string -> string.contains(substring))
                .sorted()
                .toList();
    }

    public static List<String> getSortedStringsByLength(List<String> strings) {
        if (!isValidCollection(strings)) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        return strings.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static <T> boolean checkIfAllMatch(List<T> list, Predicate<T> predicate) {
        if (!isValidCollection(list)) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        return list.stream()
                .allMatch(predicate);
    }

    public static Optional<Integer> findTheSmallestThatBiggerSomeValue(List<Integer> nums, Integer targetValue) {
        if (!isValidCollection(nums) && targetValue == null) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        return nums.stream()
                .filter(Objects::nonNull)
                .filter(num -> num > targetValue)
                .min(Comparator.comparingInt(num -> num));
    }

    public static List<Integer> mapToLengthList(List<String> list) {
        if (!isValidCollection(list)) {
            throw new IllegalArgumentException("Incorrect parameters");
        }

        return list.stream()
                .filter(Objects::nonNull)
                .map(String::length)
                .toList();
    }

    private static boolean isValidCollection(List collection) {
        return collection != null;
    }
}
