package school.faang.sprint2.task_46884;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Predicate;

public class ListOperations {
    public static int sumEven(List<Integer> numbers) {
        return numbers.stream().filter(num -> num % 2 == 0).reduce(0, (sum, number) -> sum + number);
    }

    public static int max(List<Integer> numbers) {
        Optional<Integer> max = numbers.stream().max((o1, o2) -> o1 - o2);
        return max.isPresent() ? max.get() : 0;
    }

    public static double avg(List<Integer> numbers) {
        OptionalDouble avg = numbers.stream().mapToInt(Integer::intValue).average();
        return avg.isPresent() ? avg.getAsDouble() : 0;
    }

    public static int stringStartsWith(List<String> strings, char firstChar) {
        return (int) strings.stream().filter((string) -> string.startsWith(String.valueOf(firstChar))).count();
    }

    public static List<String> filterStringsHasSubstrings(List<String> strings, String substring) {
        return strings.stream().filter((string) -> string.contains(substring)).toList();
    }

    public static List<String> sortStringsByLength(List<String> strings) {
        return strings.stream().sorted(((o1, o2) -> o1.length() - o2.length())).toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream().allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int bound) {
        return numbers.stream().filter((item) -> item > bound).min(Integer::compareTo).orElseThrow(()
                -> new NoSuchElementException("No elements greater than " + bound));
    }

    public static List<Integer> mapToLength(List<String> strings) {
        return strings.stream().map((item) -> item.length()).toList();
    }
}
