package faang.school.godbless.train_streams1;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class StreamComputer {

    public static int sumOfEvens(List<Integer> numbers) {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();

//        return numbers.stream()
//        .filter(n -> n % 2 == 0)
//        .reduce(0, Integer::sum);
    }

    public static int max(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .max()
                .orElse(-1);
    }

    public static double avg(List<Integer> numbers) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public static long countStartingWith(List<String> strings, String target) {
        return strings.stream()
                .filter(s -> s.startsWith(target))
                .count();
    }

    public static List<String> filterContainingSubstring(List<String> strings, String target) {
        return strings.stream()
                .filter(s -> s.contains(target))
                .toList();
    }

    public static List<String> sortByLength(List<String> strings, Comparator<String> comparator) {
        return strings.stream()
                .sorted(comparator)
                .toList();
    }

    public static boolean allMatchCondition(List<String> strings, Predicate<String> predicate) {
        return strings.stream()
                .allMatch(predicate);
    }

    public static int minGreaterThanTarget(List<Integer> numbers, int target) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(n -> n > target)
                .min()
                .orElse(-1);
    }

    public static List<Integer> mapToLength(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .toList();
    }
}
