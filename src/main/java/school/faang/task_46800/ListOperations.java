package school.faang.task_46800;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class ListOperations {
    public static Integer sumOfEvenNumbers(List<Integer> numbers) {
        return numbers.stream()
                .filter(f -> f % 2 == 0)
                .reduce(0, Integer::sum);
    }

    public static Integer findMax(List<Integer> numbers) {
        return numbers.stream()
                .max(Integer::compareTo)
                .orElse(null);
    }

    public static double findAverage(List<Integer> numbers) {
        return numbers.stream()
                .mapToDouble(e -> e)
                .average()
                .getAsDouble();
    }

    public static long countStringsStartingWith(List<String> words, Character character) {
        return words.stream()
                .filter(word -> word.startsWith(character.toString()))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> words, String containing) {
        return words.stream()
                .filter(word -> word.contains(containing))
                .toList();
    }

    public static List<String> sortByLength(List<String> words) {
        return words.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> predicate) {
        return numbers.stream()
                .allMatch(predicate);
    }

    public static Optional<Integer> findMinGreaterThan(List<Integer> numbers, int target) {
        return numbers.stream()
                .filter(number -> number > target)
                .min(Integer::compareTo);
    }

    public static List<Integer> convertToLengths(List<String> words) {
        return words.stream()
                .map(String::length)
                .toList();
    }
}
