package school.faang.firsttrainofstream;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class ListOperations {

    public static int sumOfEvenNumbers(List<Integer> numbers) {
        return filterNonNull(numbers).stream().filter(number -> number % 2 == 0)
                .mapToInt(number -> number).sum();
    }

    public static int findMax(List<Integer> numbers) {
        return filterNonNull(numbers).stream().max(Comparator.comparingInt(n -> n)).orElse(0);
    }

    public static double findAverage(List<Integer> numbers) {
        if (isNullOrEmpty(numbers)) {
            return 0;
        }
        int sum = numbers.stream().mapToInt(number -> number).sum();
        long count = numbers.size();
        return (double) sum / count;
    }

    public static long countStringsStartingWith(List<String> strings, char letter) {
        return filterNonNull(strings).stream().filter(string -> string.charAt(0) == letter).count();
    }

    public static List<String> filterStringsContainingSubstring(List<String> strings, String filter) {
        return filterNonNull(strings).stream().filter(string -> string.contains(filter)).toList();
    }

    public static List<String> sortByLength(List<String> strings) {
        return filterNonNull(strings).stream().sorted().toList();
    }

    public static boolean allMatchCondition(List<Integer> numbers, Predicate<Integer> condition) {
        return filterNonNull(numbers).stream().allMatch(condition);
    }

    public static int findMinGreaterThan(List<Integer> numbers, int formNumber) {
        return filterNonNull(numbers).stream().filter(number -> number > formNumber)
                .min(Comparator.comparingInt(n -> n)).orElse(0);
    }

    public static List<Integer> convertToLengths(List<String> strings) {
        return filterNonNull(strings).stream().map(String::length).toList();
    }

    private static boolean isNullOrEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }

    private static <T> List<T> filterNonNull(List<T> list) {
        return (list == null) ? Collections.emptyList() : list.stream().filter(Objects::nonNull).toList();
    }
}
