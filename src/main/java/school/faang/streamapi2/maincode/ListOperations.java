package school.faang.streamapi2.maincode;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;


public class ListOperations {
    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream().reduce(0, (sum, num) -> sum + num);
    }

    public static Optional<Integer> findMax(List<Integer> numbers) {
        return numbers.stream().max((s1, s2) -> s1 - s2);
    }

    public static Double findAverage(List<Integer> numbers) {
        OptionalDouble average = numbers.stream()
                .mapToDouble(Integer::doubleValue)
                .average();
        return average.orElse(0.0);
    }

    public static int countStringsStartingWith(List<String> lines, char symbol) {
        return (int) lines.stream().filter(s -> s.charAt(0) == symbol)
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> lines, String substring) {
        return lines.stream().filter(s -> s.contains(substring)).toList();
    }

    public static List<String> sortByLength(List<String> lines) {
        return lines.stream().sorted(Comparator.comparingInt(String::length)).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> filter) {
        return numbers.stream().allMatch(filter);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int num) {
        return numbers.stream()
                .filter(n -> n > num)
                .mapToInt(Integer::intValue)
                .min()
                .orElseThrow(NoSuchFieldError::new);
    }

    public static List<Integer> convertToLengths(List<String> lines) {
        return lines.stream().map(String::length).toList();
    }
}
