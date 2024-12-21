package school.faang.task_47078;


import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class ListOperations {
    static Integer sumOfEvenNumbers(List<Integer> listIntegers) {
        return listIntegers.stream().mapToInt(x -> x).sum();
    }

    static Integer findMax(List<Integer> listIntegers) {
        return listIntegers.stream().max(Integer::compareTo).get();
    }

    public static Double findAverage(List<Integer> numbers) {

        return numbers.stream()
                .mapToDouble(x -> (double) x)
                .average()
                .orElse(0);
    }

    public static long countStringsStartingWith(List<String> strings, Character prefix) {
        return strings.stream()
                .filter(x -> x.startsWith(
                        String.valueOf(prefix)))
                .count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String word) {
        return strings.stream()
            .filter(x -> x.contains(word))
            .toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return strings.stream()
                .sorted(Comparator.comparing(String::length))
                .toList();
    }

    public static Integer findMinGreaterThan(List<Integer> numbers, int i) {
        return numbers.stream()
                .filter(x -> x > i)
                .min(Integer::compareTo).orElse(null);
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return numbers.stream()
                .allMatch(condition);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return strings.stream()
                .map(String::length)
                .collect(Collectors.toList());
    }
}
